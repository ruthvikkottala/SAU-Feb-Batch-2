import React, { Component,useState,useEffect } from "react";
import { StyleSheet, View, Text } from "react-native";
import MaterialCardWithTextOverImage1 from "../components/MaterialCardWithTextOverImage1";

function Details({navigation}) {
  let [details,setDetails]=useState({})
    useEffect(() => {
        fetch(`https://api.themoviedb.org/3/movie/${navigation.getParam('id')}?api_key=615ee03e33e6bff6a24c739c5bbd8cc6&language=en-US`)
        .then((response)=>response.json())
        .then((data)=>{
            setDetails(data)
            // console.log(popular)
        })
        .catch((e)=>console.log(e))
    }, [])


  return (
    <View style={styles.container}>
      <Text style={styles.details}>Details</Text>
      <MaterialCardWithTextOverImage1
        titleStyle="Title goes here"
        subtitleStyle="Subtitle here"
        titleStyle={details.title}
        subtitleStyle={details.release_date}
        overview={details.overview}
        path={details.poster_path}
        style={styles.materialCardWithTextOverImage1}
        rating={details.vote_average}
        status={details.status}
        runtime={details.runtime}
      ></MaterialCardWithTextOverImage1>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "rgba(42,37,37,1)"
  },
  details: {
    color: "rgba(201,193,16,1)",
    fontSize: 42,
    marginTop: 20,
    alignSelf: "center"
  },
  materialCardWithTextOverImage1: {
    height: 267,
    width: 318,
    marginTop: 29,
    marginLeft: 29
  }
});

export default Details;
