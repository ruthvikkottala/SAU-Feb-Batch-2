import React, { Component } from "react";
import { StyleSheet, View, Image, Text, TouchableOpacity } from "react-native";

function MaterialCardWithTextOverImage1(props) {
  let calcTime=(time)=>{
    // console.log(time)
    if(time==0) return `--`
    return `${parseInt(time/60)}Hrs ${time%60}Mins`
  }
  console.log(props.poster)
  return (
    <View style={{flex:1}}>
    <View style={[styles.container, props.style]}>
      <Image
        source={{uri:`https://image.tmdb.org/t/p/w500/${props.path}`}}
        style={styles.cardItemImagePlace}
      ></Image>
      <View style={styles.cardBody}>
        <View style={styles.bodyContent}>
          <Text style={styles.titleStyle}>
            {props.titleStyle || "Title goes here"}
          </Text>
          <Text style={styles.subtitleStyle}>
            {props.subtitleStyle || "Subtitle here"}
          </Text>
        </View>
        {/* <View style={styles.actionBody}>
          <TouchableOpacity style={styles.actionButton1}>
            <Text style={styles.actionText1}>ACTION 1</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.actionButton2}>
            <Text style={styles.actionText2}>ACTION 2</Text>
          </TouchableOpacity>
        </View> */}
      </View>
      
    </View>
    <Text style={{color:'#FFF',textAlign:"auto",marginTop:10}}>Overview : {props.overview}</Text>
    <Text style={{color:'#FFF',textAlign:"left",marginTop:10}}>Ratings : {props.rating}/10</Text>
    <Text style={{color:'#FFF',textAlign:"auto",marginTop:10}}>Status : {props.status}</Text>
    <Text style={{color:'#FFF',textAlign:"left",marginTop:10}}>Runtime : {calcTime(props.runtime)}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    borderWidth: 1,
    borderRadius: 2,
    borderColor: "#CCC",
    flexWrap: "nowrap",
    backgroundColor: "#FFF",
    shadowColor: "#000",
    shadowOffset: {
      width: -2,
      height: 2
    },
    shadowOpacity: 0.1,
    shadowRadius: 1.5,
    elevation: 3,
    overflow: "hidden"
  },
  cardItemImagePlace: {
    backgroundColor: "black",
    flex: 1,
    minHeight: 359,
    resizeMode:"contain"

  },
  cardBody: {
    position: "absolute",
    bottom: 0,
    backgroundColor: "rgba(0,0,0,0.2)",
    left: 0,
    right: 0
  },
  bodyContent: {
    padding: 16,
    paddingTop: 24,
    justifyContent: "center"
  },
  titleStyle: {
    fontSize: 24,
    color: "#FFF",
    paddingBottom: 12
  },
  subtitleStyle: {
    fontSize: 14,
    color: "white",
    lineHeight: 16,
    opacity: 0.9
  },
  actionBody: {
    padding: 8,
    flexDirection: "row"
  },
  actionButton1: {
    padding: 8,
    height: 36
  },
  actionText1: {
    fontSize: 14,
    color: "#FFF",
    opacity: 0.9
  },
  actionButton2: {
    padding: 8,
    height: 36
  },
  actionText2: {
    fontSize: 14,
    color: "#FFF",
    opacity: 0.9
  }
});

export default MaterialCardWithTextOverImage1;
