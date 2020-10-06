<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <div style="padding-top: 200px;padding-left: 500px">
        <tag-cloud :data="tags"></tag-cloud>
      </div>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
export default {
  name: 'Tag',
  components: { SideBar },
  data () {
    return {
      tags: []
    }
  },
  created () {
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/tag/findAll'
    }).then(response => {
      var tags = response.data
      for (var i = 0; i < tags.length; i++) {
        var o = {}
        o.id = i.toString()
        o.name = tags[i]
        _this.tags.push(o)
      }
    })
  }
}
</script>

<style scoped>
</style>
