import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

import { AppLoading } from 'expo';
import { StatusBar } from 'expo-status-bar';
import {
  useFonts,
  Play_400Regular,
  Play_700Bold
} from '@expo-google-fonts/play'

import Header from './src/components/Header';

export default function App() {

  const [fontsLoaded] = useFonts({
    Play_400Regular,
    Play_700Bold
  });

  if (!fontsLoaded) {
    return <AppLoading />
  } else {
    return (
      <View>
        <Header />
        <StatusBar style="light" />
      </View>
    );
  }
}