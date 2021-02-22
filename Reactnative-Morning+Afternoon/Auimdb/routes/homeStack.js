import {createStackNavigator} from 'react-navigation-stack';
import { createAppContainer } from "react-navigation";
import  TopRated  from "../screens/TopRated";
import  Home  from "../screens/Home";
import  Popular  from "../screens/Popular";
import  Upcoming  from "../screens/Upcoming";
import Details from '../screens/Details'
const screens={
    Home:{
        screen:Home
    },
    TopRated:{
        screen:TopRated
    },
    Popular:{
        screen:Popular
    },
    Upcoming:{
        screen:Upcoming
    },
    Details:{
        screen:Details
    }
}
const HomeStack=createStackNavigator(screens)

export default createAppContainer(HomeStack);