import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Navigator from './routes/homeStack'
 
export default function App() {
  return (
    <View style={styles.container}>
      {/* <Home /> */}
      {/* <TopRated /> */}
      {/* <Details /> */}
      {/* <Upcoming/> */}
      {/* <Popular /> */}
      <Navigator/>
    </View>
    
  );
}

const styles=StyleSheet.create({
  container:{
    flex:1,
    padding:10,
    backgroundColor: "rgba(62,55,55,1)",
  }
})







