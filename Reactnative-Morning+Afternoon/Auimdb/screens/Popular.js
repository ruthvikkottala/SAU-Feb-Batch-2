import React, { Component,useState,useEffect } from "react";
import { StyleSheet, View, Text,FlatList,TouchableOpacity } from "react-native";
import MaterialCardWithTextOverImage from "../components/MaterialCardWithTextOverImage";

function Popular({navigation}) {
    let [popular,setPopular]=useState([])
    useEffect(() => {
        fetch('https://api.themoviedb.org/3/movie/popular?api_key=615ee03e33e6bff6a24c739c5bbd8cc6&language=en-US&page=1&region=IN')
        .then((response)=>response.json())
        .then((data)=>{
            setPopular(data.results)
            // console.log(popular)
        })
        .catch((e)=>console.log(e))
    }, [])


  return (
    <View style={styles.container}>
      <Text style={styles.topRated}>Popular</Text>
      <FlatList 
      keyExtractor={(item)=>item.id}
      data={popular}
      renderItem={({item})=>{
        return(
            // <TouchableOpacity onPress={()=>navigation.navigate('Details',{id:item.id})}>
            // <View>
            //     <Text>{item.title}</Text>
            // </View>
            // </TouchableOpacity>
            <TouchableOpacity onPress={()=>navigation.navigate('Details',{id:item.id})}>
              <MaterialCardWithTextOverImage
                titleStyle="Title goes here"
                subtitleStyle="Subtitle here"
                titleStyle={item.title}
                subtitleStyle={`Rating: ${item.vote_average}`}
                path={item.poster_path}
                style={styles.materialCardWithTextOverImage}
                >

                </MaterialCardWithTextOverImage>
              </TouchableOpacity>
        )
    }}/>
      
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "rgba(44,38,38,1)"
  },
  topRated: {
    
    color: "rgba(216,208,14,1)",
    fontSize: 45,
    width: 182,
    height: 56,
    textAlign: "justify",
    marginTop: 20,
    alignSelf: "center"
  },
  materialCardWithTextOverImage: {
    height: 214,
    width: 358,
    marginTop: 18,
    marginLeft: 8
  }
});

export default Popular;
