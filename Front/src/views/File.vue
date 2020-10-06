<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <el-aside>
        <ul>
          <li v-for="(count,time) in times" :key="time" :label="time">
            <el-badge class="item" :value="count">
              <el-button @click="goto(time)">{{time}}</el-button>
            </el-badge>
          </li>
        </ul>
      </el-aside>
      <el-main>
          <FArticles :fid="date"></FArticles>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
import FArticles from '../components/FArticles'
export default {
  name: 'File',
  components: { SideBar, FArticles },
  data () {
    return {
      times: [],
      date: null
    }
  },
  methods: {
    goto (fid) {
      this.date = fid
    }
  },
  created () {
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/file/findAll'
    }).then(response => {
      _this.times = response.data
      _this.date = Object.keys(_this.times)[0]
    })
  }
}
</script>

<style scoped>
.item{
  padding: 10px;
}
ul li{
  list-style-type: none;
}
</style>
