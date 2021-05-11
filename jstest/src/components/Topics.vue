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


    <p>当前是第{{page}}页</p>


    <p>这里是页码的标签 横向排列 最多显示十个

    </p>
    <router-link :to="{path:'topics',query:{page:page}}">
      <button @click = "page++">下一页 </button>
    </router-link>
    <p>跳转页
      <input v-model="npage" placeholder="输入要跳转的页码……">
      <router-link :to="{path:'topics',query:{page:npage}}">
        <button >跳转到 </button>
      </router-link>
    </p>
    <p>发帖框
      <input v-model="title" placeholder="输入要发送的标题……">

    </p>
    <input v-model="content" placeholder="输入要发送的内容……">
    <button @click = "createTopics">发送！ </button>
    {{ createinfo }}



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
      page:1,
      npage:1,
      topics:[],
      title:"",
      content:"",
      createinfo:null
    }
  },
  //created 在模板渲染成html前调用
  created:function (){
    this.loadTopics()
  },

  watch:{
    '$route':'loadTopics'

  },


  methods:{
    loadTopics(){

      let _this=this
      //默认是给自己发的
      //获取get请求中的参数
      _this.page=this.$route.query.page;
      //let url = "api/topics?page=1"
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