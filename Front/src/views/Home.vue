<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>

    <el-container>
      <el-backtop></el-backtop>
      <el-header style="height: 600px">
        <el-carousel class="banner">
          <el-carousel-item class="banner1">
            <el-tag class="tag">少说话，多做事</el-tag>
          </el-carousel-item>
          <el-carousel-item class="banner2">
            <el-tag class="tag">为什么你愿意吃生活的苦，而不愿意吃学习的苦</el-tag>
          </el-carousel-item>
          <el-carousel-item class="banner3">
            <el-tag class="tag">干就完事了</el-tag>
          </el-carousel-item>
        </el-carousel>
      </el-header>
      <el-main>
          <el-card class="card" v-for="article in articels" :key="article.id">
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
          <div style="width: 100%;text-align: center;margin-top: 50px">
            <el-pagination
              background
              :hide-on-single-page="true"
              :page-size="5"
              layout="prev, pager, next"
              :total="total"
            @current-change="page">
            </el-pagination>
          </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
export default {
  name: 'Home',
  components: { SideBar },
  data () {
    return {
      articels: null,
      total: null
    }
  },
  methods: {
    page (currentPage) {
      const _this = this
      this.axios({
        method: 'get',
        url: 'http://120.25.169.91:8080/api/article/findAll/' + currentPage + '/5'
      }).then(response => {
        _this.articels = response.data.rows
      })
    }
  },
  created () {
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/article/findAll/1/5'
    }).then(response => {
      _this.articels = response.data.rows
      _this.total = response.data.total
    })
  }
}
</script>

<style scoped>
el-aside{
  width: 300px;
  height: auto;
}
.banner{
  width: 1000px;
  height: 500px;
  margin-top: 50px;
  margin-left: 250px;
}
.el-carousel__item{
  height: 500px;
}
.banner1{
  background-image: url("../assets/banner1.jpg");
}
.banner2{
  background-image: url("../assets/banner2.jpg");
}
.banner3{
  background-image: url("../assets/banner3.jpg");
}
.tag{
  font-size: 45px;
  font-weight: bolder;
  height: 150px;
  width: 100%;
  background: rgba(255,255,255,0.55);
  text-align: center;
  margin-top: 250px;
  color: #231f1f;
  border: none;
  line-height: 150px;
}
.card {
  width: 1000px;
  height: 300px;
  margin-left: 250px;
  margin-top: 50px;
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
