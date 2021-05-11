<template>
  <!--此处的app与下面的css对应-->
  <div id="app">
    <img alt="Vue logo" src="./assets/avatar_1594707071.png" width="150" height="150">
  <ul class="center">
<!--    <li> <router-link  to="/foo" >切换到Foo组件</router-link></li>-->
<!--    <li> <router-link  to="/hello">切换到hello组件</router-link></li>-->
  </ul>


    <router-view></router-view>

  </div>
</template>
//根组件 所有组件都包含在此组件中
<script>

export default {
  name: 'App'

}




</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  margin-top: 2px;
  margin-left: 2px;


}
.center
{
  margin-top: 2px;
  text-align:center;
}

</style>
