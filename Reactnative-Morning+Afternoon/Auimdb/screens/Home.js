import React, { Component } from "react";
import { StyleSheet, View, Text, Image, ImageBackground,TouchableOpacity } from "react-native";
import CustomButtonWarning from "../components/CustomButtonWarning";


export default function Home({navigation}) {
  return (
    <View style={styles.container}>
      <View style={styles.rect}>
        <Text style={styles.aUimdb}>AUimdb</Text>
        <ImageBackground
          source={require("../assets/images/bg.jpg")}
          resizeMode="contain"
          style={styles.image}
          imageStyle={styles.image_imageStyle}
        >
          <Text style={styles.loremIpsum}>
            One Stop for your{"\n"}Favourite movies...
          </Text>
        </ImageBackground>
        <View style={styles.customButtonWarningRow}>
          <TouchableOpacity onPress={()=>navigation.navigate('TopRated')}>
          <CustomButtonWarning
            caption="TopRated"
            style={styles.CustomButtonWarning}
            
          ></CustomButtonWarning>
          </TouchableOpacity>
           <TouchableOpacity onPress={()=>navigation.navigate('Popular')}>
          <CustomButtonWarning
            caption="Button"
            caption="Popular"
            style={styles.CustomButtonWarning1}
          ></CustomButtonWarning>
          </TouchableOpacity>
           <TouchableOpacity onPress={()=>navigation.navigate('Upcoming')}>
          <CustomButtonWarning
            caption="Button"
            caption="Upcoming"
            style={styles.CustomButtonWarning2}
          ></CustomButtonWarning>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
   flex:1
    
  },
  rect: {
    // width: 375,
    // height: 812,
    flex:1,
    backgroundColor: "rgba(62,55,55,1)"
  },
  aUimdb: {
    // flex:1,
    color: "rgba(197,197,25,1)",
    fontSize: 51,
    // marginTop: 48,
    marginLeft: 96
  },
  image: {
    flex:1,
    width: 375,
    height: 554
  },
  image_imageStyle: {},
  loremIpsum: {
    color: "rgba(243,240,240,1)",
    fontSize: 42,
    marginTop: 62,
    marginLeft: 15
  },
  CustomButtonWarning: {
    // flex:1,
    height: 50,
    width: 100,
    borderWidth: 3,
    borderColor: "#000000",
    borderRadius: 13
  },
  CustomButtonWarning1: {
    // flex:1,
    height: 50,
    width: 100,
    borderWidth: 3,
    borderColor: "#000000",
    borderRadius: 13,
    marginLeft: 18
  },
  CustomButtonWarning2: {
    // flex:1,
    height: 50,
    width: 100,
    borderWidth: 3,
    borderColor: "#000000",
    borderRadius: 13,
    marginLeft: 19
  },
  customButtonWarningRow: {
    // flex:1,
    height: 44,
    flexDirection: "row",
    marginTop: 11,
    marginLeft: 20,
    marginRight: 18,
    marginBottom:20,
    
  }
});


