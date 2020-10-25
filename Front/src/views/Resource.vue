<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <h1>有待开发</h1>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
export default {
  name: 'Resource',
  components: { SideBar }
}
</script>

<style scoped>
h1{
  font-size: 50px;
  font-weight: bolder;
}
</style>
