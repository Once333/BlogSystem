<template>
  <el-container>
    <el-aside>
      <SideBar></SideBar>
    </el-aside>
    <el-container>
      <el-backtop></el-backtop>
      <div class="mblog">
        <h1 class="title">{{ blog.title }}</h1>
        <div class="info">
          <span><i class="el-icon-user-solid"></i>Jackson</span>
          <span><i class="el-icon-collection"></i>{{ blog.category }}</span>
          <span><i class="el-icon-collection-tag"></i>{{ blog.tag }}</span>
          <span><i class="el-icon-timer"></i>{{ blog.time }}</span>
        </div>
        <el-divider></el-divider>
        <div v-html="blog.content" class="markdown-body"></div>
      </div>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from '../components/SideBar'
import marked from 'marked'
import hljs from 'highlight.js'
import 'highlight.js/styles/atom-one-light.css'
import 'github-markdown-css/github-markdown.css'
export default {
  name: 'Blog',
  components: { SideBar },
  data () {
    return {
      blog: {
        title: null,
        content: null,
        category: null,
        tag: null,
        time: null
      }
    }
  },
  methods: {
    markdown () {
      marked.setOptions({
        renderer: new marked.Renderer(),
        highlight: function (content) {
          return hljs.highlightAuto(content).value
        },
        gfm: true,
        tables: true,
        breaks: false,
        pedantic: false,
        smartLists: true,
        sanitize: true,
        smartypants: false
      })
    }
  },
  created () {
    const blogId = this.$route.params.blogId
    const _this = this
    this.axios({
      method: 'get',
      url: 'http://120.25.169.91:8080/api/article/' + blogId
    }).then(response => {
      const artilce = response.data
      _this.blog.title = artilce.title
      _this.blog.category = artilce.cname
      _this.blog.tag = artilce.tname
      _this.blog.time = artilce.time
      _this.blog.content = marked(artilce.content)
      _this.markdown()
    })
  }
}
</script>

<style scoped>
.mblog{
  width: 80%;
  margin-left: 150px;
}
.title{
  font-size: 50px;
  font-weight: bolder;
  margin-top: 50px;
  height: 100px;
}
span{
  padding-right: 100px;
}
</style>
