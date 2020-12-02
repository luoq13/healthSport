<template>
    <div class="login_container">

<!-- 系统logo -->
        <div class="login_box">
            <div class="head_img">
                <img src="../assets/1.jpg">
            </div>

<!-- 表单 -->
            <div class="div_login_form">
                <el-form :rules="rules" ref="login_form_ref" :model="loginData" class="login_form" label-width="0px">
                  
                    <el-form-item prop="username">
                        <el-input prefix-icon="iconfont icon-iconset01100
" v-model="loginData.username" placeholder="用户名"></el-input>
                    </el-form-item>
                   
                    <el-form-item prop="password">
                        <el-input prefix-icon="iconfont icon-mima" type="password"
                         v-model="loginData.password" placeholder="密码"></el-input>
                    </el-form-item>
                   
                    <el-form-item class="btn">
                        <el-button type="primary" @click="login">登录</el-button>
                        <el-button type="info" @click="resetLoginForm()">重置</el-button>
                    </el-form-item>

                </el-form>
            </div>
            
        </div>
    </div>
</template>

<script>
export default {
    data(){
        return{
            loginData:{
                username:'',
                password:''
            },
            rules: {
                username: [
                    { required: true, message: '用户名不能为空！', trigger: 'blur' },
                    { min: 5, max: 12, message: '长度在 5 到 12 个字符', trigger: 'blur' }
                ],
            password: [
                    { required: true, message: '密码不能为空！', trigger: 'blur' },
                    { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
                ],
            }
        }
    },
    methods:{
        // 重置表单
        resetLoginForm(){
            this.$refs.login_form_ref.resetFields();
        },
        login(){
            this.$refs.login_form_ref.validate(async valid => {
                if(!valid){
                    this.$message.error('请输入正确的用户名或密码！');
                    return;
                }
                // const res = await this.$http.post('hello');
                // console.log(res);
                // if(res.data == 'ok'){
                //     this.$message.success('欢迎！登录成功');
                //     this.$router.push({path:'/home'});
                // }else{
                //     this.$message.error('登录失败！');
                // }
                await this.$http.post('login',this.loginData).then(res => {
                if(res.data.flag == 'ok'){
                    this.$message.success('欢迎  '+res.data.user.username+  '！登录成功');
                    window.sessionStorage.setItem('user',res.data.user)
                    this.$router.push({path:'/home'});
                }else{
                    this.$message.error('登录失败！');
                }
                })
            });
        }
    }
}
</script>

<style lang="less" scoped>
    .login_container{
        background-color: #2b4b6b;
        height: 100%;
    }
    .login_box{
        width: 450px;
        height: 300px;
        background-color: #fff;
        border-radius: 3px;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%,-50%);
        .head_img{
            width: 130px;
            height: 130px;
            border: 1px solid #eee;
            border-radius: 50%;
            padding: 10px;
            box-shadow: 0 0 10px #ddd;
            position: absolute;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: #0ee;
        img{
            width: 100%;
            height: 100%;
            border-radius: 50%;
            background-color: #eee;
        }
    }
    .btn{
        display: flex;
        justify-content: flex-end;
    }
    .login_form{
        position: absolute;
        bottom: 0;
        width: 100%;
        padding: 0 50px;
        box-sizing: border-box;
    }
    }
    
</style>