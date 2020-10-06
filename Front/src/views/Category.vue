<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <el-tabs class="tabs">
        <el-tab-pane v-for="category in categories" :key="category.id" :label="category.name" @tab-click="goto(category.id)">
          <CArticles :cid="category.id"></CArticles>
        </el-tab-pane>
      </el-tabs>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
import CArticles from '../components/CArticles'
export default {
  name: 'Category',
  components: { SideBar, CArticles },
  data () {
    return {
      categories: null
    }
  },
  methods: {
    goto (cid) {
      this.$router.replace({ name: 'CArticles', params: { cid: cid } })
    }
  },
  created () {
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/category/findAll'
    }).then(response => {
      _this.categories = response.data
    })
  }
}
</script>

<style scoped>
el-aside{
  width: 300px;
  height: auto;
}
.tabs{
  width: 1000px;
  margin-left: 250px;
  margin-top: 20px;
}
.tabs /deep/ .el-tabs__item{
  font-size: 20px;
  font-weight: normal;
  padding-right: 50px;
}
</style>
