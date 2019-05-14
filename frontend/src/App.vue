<template>
  <div id="app">
    <router-view></router-view>
    <!-- <div id="nav">
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </div>
    <router-view/> -->
  </div>
</template>

<style>

#app {

}
#nav {

}
@import "//unpkg.com/nes.css@latest/css/nes.min.css";
@import "assets/css/bulma.css";


.test{
    border-style: solid;
    border-color: #fff;
    background-color: aqua; 
    /* widows: 100px;  
    height: 100px; */
}
/* 页面默认撑满 */
*{
     margin: 0;
     padding: 0;
}
html,body{
    /* width: 100%;
    height: 100%; */
}
div{
    /* width:100%;
    height: 100%; */
}

div {
    font-family: "JfDotMPlus";
}

</style>
