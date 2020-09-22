import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';

const Header = () => {
    return (
        <View style={sytles.header}>
            <Image source={require('../../assets/logo.png')}/>
            <Text style={sytles.textLogo1}>Game Ranks</Text>
            <Text style={sytles.textLogo2}>Survey</Text>
        </View>
    );
};

const sytles = StyleSheet.create({
    text: {
        color: '#FFF',
        fontSize: 40,
    },
    header: {
        paddingTop: 50,
        height: 90,
        backgroundColor: '#37474F',
        flexDirection: 'row',
        justifyContent: 'center'
    },
    textLogo1: {
        fontWeight: 'bold',
        fontSize: 18,
        fontFamily: "Play_700Bold",
        color: '#ED7947',
        marginLeft: 10,
        marginRight: 5,
    },
    textLogo2: {
        fontWeight: 'bold',
        fontFamily: "Play_700Bold",
        fontSize: 18,
        color: '#FFF'
    },
    tinyLogo: {
        width: 25,
        height: 25,
    },
})

export default Header;