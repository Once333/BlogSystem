<template>
  <div style="margin-top: 30px">
    <el-backtop></el-backtop>
    <el-card class="card" v-for="article in articles" :key="article.id">
      <div class="main">
        <div class="title">
          <router-link :to="{ name: 'Blog', params: { blogId: article.id } }" style="text-decoration: none;color: darkturquoise">
            {{ article.title }}
          </router-link>
        </div>
        <div class="info">
          <div class="information"><i class="el-icon-user-solid"></i>Jackson</div>
          <div class="information"><i class="el-icon-collection"></i>{{ article.cname }}</div>
          <div class="information"><i class="el-icon-collection-tag"></i>{{ article.tname }}</div>
          <div class="information"><i class="el-icon-timer"></i>{{ article.time }}</div>
        </div>
      </div>
      <div class="image">
        <img :src="'data:image/jpeg;base64,' + article.cover"/>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: 'CArticles',
  props: ['cid'],
  data () {
    return {
      articles: null
    }
  },
  created () {
    const cid = this.cid
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/category-' + cid + '/articles'
    }).then(response => {
      _this.articles = response.data
    })
  }
}
</script>

<style scoped>
.card{
  margin-bottom: 50px;
}
.card /deep/ .el-card__body{
  padding: 0;
  display: flex;
  justify-content: space-between;
}
.main{
  width: 60%;
  height: 300px;
  text-align: center;
}
.image{
  width: 40%;
  height: 300px;
}
.title{
  font-size: 50px;
  font-weight: bolder;
  margin-top: 50px;
  height: 100px;
}
.info{
  padding: 50px;
}
.information{
  float: left;
  width: 25%;
}
</style>
