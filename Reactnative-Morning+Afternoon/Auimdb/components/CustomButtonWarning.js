import React, { Component } from "react";
import { StyleSheet, View, Text } from "react-native";

function CustomButtonWarning(props) {
  return (
    <View style={[styles.container, props.style]}>
      <Text style={styles.caption}>{props.caption || "Button"}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: "#FFCC00",
    justifyContent: "center",
    alignItems: "center",
    flexDirection: "row",
    borderRadius: 5,
    paddingLeft: 16,
    paddingRight: 16
  },
  caption: {
    color: "#000",
    fontWeight:'bold',
    fontSize: 12
  }
});

export default CustomButtonWarning;
