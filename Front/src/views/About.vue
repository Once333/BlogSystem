<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <el-backtop></el-backtop>
      <div class="info">
        <el-card>
          <h2>关于我</h2>
          <p>
            <strong>站 长：</strong>&#12288;young
          </p>
          <p>
            <strong>网 址：</strong>&#12288;young12138.top
          </p>
          <p>
            <strong>就读大学：</strong>&#12288;中南大学
          </p>
          <p>
            <strong>个人简介：</strong>&#12288;本人系中南大学自动化的一名学生，无奈对控制领域不感兴趣，自学Java，希望转行互联网领域，志同道合的兄弟们可以一起上车啊！！！</p>
          <h2 style="padding-top: 50px">联系方式</h2>
          <p>
            <strong>微信：</strong>&#12288;zzz1213867
          </p>
          <p>
            <strong>Q Q：</strong>&#12288;494953469
          </p>
          <p>
            <strong>邮箱：</strong>&#12288;494953469@qq.com
          </p>
          <p>
            <strong>知乎：</strong>&#12288;Once
          </p>
          <h2 style="padding-top: 50px">更新日志</h2>
        </el-card>
      </div>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
export default {
  name: 'About',
  components: { SideBar }
}
</script>

<style scoped>
.info{
  margin-left: 250px;
  margin-top: 30px;
}
</style>
