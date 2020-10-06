<template>
  <div>
    <el-menu class="menu" mode="vertical" :default-active="this.$route.path" router>
      <el-menu-item class="image"></el-menu-item>
      <el-menu-item v-for="(item, i) in navList" :key="i" :index="item.name" style="text-align: center;margin: 20px">
        <template slot="title">
          <span>{{ item.navItem }}</span>
        </template>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
      navList: [
        { name: '/', navItem: '主页' },
        { name: '/category', navItem: '分类' },
        { name: '/tag', navItem: '标签' },
        { name: '/file', navItem: '归档' },
        { name: '/resource', navItem: '资源' },
        { name: '/about', navItem: '关于我' }
      ]
    }
  }
}
</script>

<style scoped>
.menu{
  width: 295px;
  position: fixed;
  top: 0;
  left: 0;
  height: 100%;
}
.image{
  width: 295px;
  height: 200px;
  background-image: url("../assets/logo.png");
}
span{
  font-weight: bolder;
  font-size: 20px;
}
</style>
