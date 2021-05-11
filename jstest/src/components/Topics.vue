<template>
  <div class="center">
    <p>这里就是bbs主页
    下面一堆主题帖的框框
    </p>

    {{ info }}


    <tr v-for="topic in topics" :key="topic">
      <td>{{ topic.id }} </td>
      <td>{{ topic.title }} </td>
      <td>点击数</td>
      <td>{{ topic.views }} </td>
      <td>回复数</td>
      <td>{{ topic.replies }} </td>
<!--      <td>{{ topic.views }} </td>-->

    </tr>


    <p>当前是第{{page}}页 共{{totalpage}}页</p>


<!--    <p>这里是页码的标签 横向排列 最多显示十个-->

<!--    </p>-->
    <router-link :to="{path:'topics',query:{page:page}}">
      <button @click = "page++">下一页 </button>
    </router-link>
    <p>跳转到第
      <input v-model="npage" placeholder="输入要跳转的页码……">
      页
      <router-link :to="{path:'topics',query:{page:npage}}">
        <button >go </button>
      </router-link>
    </p>
    <p>发帖框
      <input v-model="title" placeholder="输入要发送的标题……">

    </p>
    <input v-model="content" placeholder="输入要发送的内容……">
    <button @click = "createTopics">发送！ </button>
    {{ createinfo }}

  <router-link :to="{path:'/login'}" event = "toLogin"> </router-link>



  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Topics",
  //属性的初始化
  data(){
    return{
      info: null,
      //当前的页码
      page:1,
      //要跳转的页码
      npage:1,
      //后端总共的页码
      totalpage:1,
      topics:[],
      title:"",
      content:"",
      createinfo:null,

    }
  },
  //created 在模板渲染成html前调用
  created:function (){
    this.loadTopics()
  },

  watch:{
    '$route':'loadTopics',




  },


  methods:{
    loadTopics(){

      let _this=this
      //默认是给自己发的
      //获取get请求中的参数
      _this.page=this.$route.query.page;

      let url2 = "api/topics/pageNum";


      axios.get(url2).then(successResponse=>{
        //加载总页数
        _this.totalpage=successResponse.data.data
      }).catch(function (error) { // 请求失败处理
        console.log(error);
      });

      //读取分页内容
      if(_this.page>_this.totalpage){//页数过长
        _this.page=_this.totalpage;

      }
      if(_this.page<=0){
        _this.page=1;

      }
      let url = "api/topics?page="+_this.page;
      axios.get(url).then(successResponse=>{
        _this.info=successResponse;
        //将response中的数据读入topic数组
        _this.topics=successResponse.data.data
      }).catch(function (error) { // 请求失败处理
        console.log(error);
      });

    },
    createTopics(){

      let _this=this;
      axios.post('api/topics', {
        title: _this.title,        // 参数 firstName
        content: _this.content   // 参数 lastName
      }).then(response=>{
        _this.createinfo=response.data;
        if(response.data.success==false){//登录失败的处理逻辑
          alert(response.data.errorMsg +'!'+'点击后跳转到登录页面！');
          this.$router.push({path:'/login'});
        }
        //将response中的数据读入createinfo字段中
      }).catch(function (error) { // 请求失败处理
        console.log(error);
      });






    }


  }
}
</script>

<style scoped>

</style>