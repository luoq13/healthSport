<template>
    <el-container class="home-container">

        <el-header class="el-header">
            <div>
                <img src="../assets/home.png" alt="自律及自由" />    
                <span>
                个人运动后台管理
                </span> 
            </div>
            <div>
                <!-- @click="drawer = true" -->
                <el-button style="color:rgb(11,99,196);" type="info" icon="iconfont icon-lianxiwomen" @click="open" circle></el-button> 
                <el-button style="color:rgb(11,99,196);" type="info" icon="iconfont icon-tuichu" circle @click="loginOut"></el-button> 
            </div>
        </el-header>

        <el-container>

            <el-aside class="el-aside" width="200px">
            
                <!-- <div class="toggle-button">|||</div> -->

                <el-menu :default-active="defaultPath"
                                router
                         unique-opened
                         class="el-menu-vertical-demo"
                         background-color="#545c64"
                         text-color="#fff">
                            <el-submenu :index="item.path" v-for="item in menuList" :key="item.id">
                                <template slot="title">
                                    <i :class="icon[item.id]" style="font-size:20px;margin-right:10px;color:rgb(81,130,245);"></i>
                                    <span>{{item.title}}</span>
                                </template>
                                <el-menu-item-group v-for="it in item.menuList" :key="it.id" >
                                    <el-menu-item :index="it.path" @click="savePath(it.path)" style="margin-left:10px;" router>{{it.title}}</el-menu-item>
                                </el-menu-item-group>
                            </el-submenu>
                </el-menu>

            </el-aside>

            <el-main class="el-main">

                <router-view></router-view>

            </el-main>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        data(){
            return{
                menuList:[],
                icon: {
                    '100':'iconfont icon-quanxianguanli',
                    '200':'iconfont icon-51'
                    },
                defaultPath:'',
            }
        },
        created(){
            this.getMenuList();
            this.defaultPath = window.sessionStorage.getItem('savePath')
        },
        methods:{
            // 获取侧边栏列表数据
             async getMenuList(){
               await this.$http.get('menus').then(res => {
                   if(res.data.flag != 'ok'){
                       this.$message.error('获取数据失败！');
                   }
                   this.menuList = res.data.menus;
                //    console.log(this.menuList)
               })
            },
            savePath(save){
                console.log(save)
                this.defaultPath = save;
                window.sessionStorage.setItem('savePath',save);
            },
            async loginOut(){
                 const confirmResult = await this.$confirm('确定要退出登录？','提示',{
                    confirmButtonText:'确定',
                    cancelButtonText:'取消',
                    type:'warning'
                }).catch(err => err)
                if(confirmResult != 'confirm'){
                    return this.$message.info('已取消此操作');
                }
                window.sessionStorage.clear();
                this.$router.push('/login');
                 return this.$message.success('当前用户已退出登录');
            },
            open(){
                this.$alert('<p>QQ：282055016</p><p>微信：hello_2020_l</p><p>电子邮箱：email_luoqiang@163.com</p>', '联系我们', {
                confirmButtonText: '确定',
                center: true,
                dangerouslyUseHTMLString:true,
                callback: action => {
                    this.$message({
                    type: 'success',
                    message: `如有好的建议欢迎联系我们,谢谢！`
                    });
                }
                });
            }
        }
    }
</script>

<style lang="less" scoped>
    .el-header{
        background-color: #373d41;
        display: flex;
        justify-content: space-between;
        padding-left: 0;
        color: white;
        font-size: 20px;
        >div{
            display: flex;
            align-items: center;
            span{
                margin-left: 15px;
            }
        }
    }
    .el-aside{
        background-color: #333744;
        .el-menu-vertical-demo{
            border-right: none;
        }
    }
    .el-main{
        background-color: #eaedf1;
    }
    .home-container{
        height: 100%;
    }
    img{
        width: 55px;
        height: 55px;
    }
    .toggle-button{
        background-color: #4a5064;
        font-size: 10px;
        line-height: 24px;
        color:#fff;
        text-align: center;
        letter-spacing: 0.2em;
        cursor: pointer;
    }
</style>
