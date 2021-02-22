import React, { Component,useState,useEffect } from "react";
import { StyleSheet, View, Text,FlatList,TouchableOpacity } from "react-native";
import MaterialCardWithTextOverImage from "../components/MaterialCardWithTextOverImage";

function Upcoming({navigation}) {
    let [upcoming,setUpcoming]=useState([])
    useEffect(() => {
        fetch('https://api.themoviedb.org/3/movie/upcoming?api_key=615ee03e33e6bff6a24c739c5bbd8cc6&language=en-US&page=1&region=IN')
        .then((response)=>response.json())
        .then((data)=>{
            setUpcoming(data.results)
            // console.log(upcoming)
        })
        .catch((e)=>console.log(e))
    }, [])

  return (
    <View style={styles.container}>
      <Text style={styles.topRated}>Upcomin</Text>
      <FlatList
      keyExtractor={(item)=>item.id}
      data={upcoming}
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
                subtitleStyle={`ReleaseDate: ${item.release_date}`}
                style={styles.materialCardWithTextOverImage}
                path={item.poster_path}>
                  
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

export default Upcoming;
