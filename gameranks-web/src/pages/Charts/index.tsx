import React, { useEffect, useState } from 'react';
import Filters from '../../components/Filters';
import './styles.css';
import { barOptions, pieOptions } from './chart-options';
import Chart from 'react-apexcharts';
import axios from 'axios';
import { buildBarSeries, getGenderChartData, getPlatformChartData } from './helpers';

const BASE_URL = 'http://localhost:8080';

type PieChartData = {
    labels: string[];
    series: number[];
}

type BarChartData = {
    x: string;
    y: number;
}

const initialPieData = {
    labels: [],
    series: []
}

const Charts = () => {
    const [barChartData, setBarChartData] = useState<BarChartData[]>([]);
    const [platformData, setPlatformData] = useState<PieChartData>(initialPieData);
    const [genderData, setGenderData] = useState<PieChartData>(initialPieData);

    useEffect(() => {
        function getData() {
            Promise.all([
                axios.get(`${BASE_URL}/records`),
                axios.get(`${BASE_URL}/games`)
            ]).then(result => {
                const recordsData = result[0].data.content;
                const gamesData = result[1].data;

                const barData = buildBarSeries(gamesData, recordsData);
                const platformData = getPlatformChartData(recordsData);
                const genderData = getGenderChartData(recordsData);

                setBarChartData(barData);
                setPlatformData(platformData);
                setGenderData(genderData);
            }).catch(err => console.log(err))

        }
        getData();
    }, []);

    return (
        <div className="page-container">
            <Filters
                link="/records"
                linkText="VER TABELA"
            />
            <div className="chart-container">
                <div className="top-related">
                    <h1 className="top-related-title">
                        Jogos mais votados
                    </h1>
                    <div className="games-container">
                        <Chart
                            options={barOptions}
                            type="bar"
                            width="900"
                            height="650"
                            series={[{ data: barChartData }]}
                        />
                    </div>
                </div>
                <div className="charts">
                    <div className="platform-chart">
                        <h2>Plataformas</h2>
                        <Chart
                            options={{ ...pieOptions, labels: platformData?.labels }}
                            type="donut"
                            series={platformData?.series}
                            width="350"
                        />
                    </div>
                    <div className="gender-chart">
                        <h2>Gêneros</h2>
                        <Chart
                            options={{ ...pieOptions, labels: genderData?.labels }}
                            type="donut"
                            series={genderData?.series}
                            width="350"
                        />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Charts;
