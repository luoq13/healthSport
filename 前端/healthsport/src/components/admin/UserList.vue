<template>
    <div>
        
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>权限管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户列表</el-breadcrumb-item>
        </el-breadcrumb>
    

            <el-card>

<!-- 搜索添加 -->
                <el-row :gutter="25">
                    <el-col :span="10">
                        <el-input placeholder="请输入搜索内容" v-model="pageInfo.info" clearable @clear="getUserList" >
                            <el-button slot="append" icon="el-icon-search" @click="getUserList"></el-button>
                        </el-input>
                    </el-col>
                    <el-col :span="4">
                        <el-button type="primary" @click="addDialogVisible = true">添加用户</el-button>
                    </el-col>
                </el-row>

<!-- 表格内容 -->
                <el-table :data="userList" border stripe>
                    <el-table-column type="index"></el-table-column>
                    <el-table-column label="用户名" prop="username"></el-table-column>
                    <el-table-column label="邮箱" prop="email"></el-table-column>
                    <el-table-column label="角色" prop="role"></el-table-column>
                    <el-table-column label="状态" prop="state">
                        <template slot-scope="scope">
                            <el-switch v-model="scope.row.state" @change="updateState(scope.row)"></el-switch>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button type="primary" icon="iconfont icon-bianji" size="mini" @click="showEditDialog(scope.row.id)"></el-button>
                            <el-button type="danger" icon="iconfont icon-delete" size="mini" @click="deleteUser(scope.row.id)"></el-button>
                            <el-tooltip effect="dark" content="分配权限" placement="top-start" :enterable="false">
                                <el-button type="warning" icon="iconfont icon-shezhi" size="mini"></el-button>
                            </el-tooltip>
                        </template>
                    </el-table-column>
                </el-table>

<!-- 分页组件 -->
                <div>
                    <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="pageInfo.pageNum"
                        :page-sizes="[1, 5,,7, 10, 100]"
                        :page-size="pageInfo.pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
                    </el-pagination>
                </div>

            </el-card>
        
<!-- 新增用户区域 -->
            <el-dialog title="新增用户" :visible.sync="addDialogVisible" width="50%" @close="dialogClose">
                <el-form :model="addForm" :rules="addFormRules" ref="addFormRef" label-width="70px">
                    <el-form-item prop="username">
                        <el-input prefix-icon="iconfont icon-iconset01100" v-model="addForm.username" placeholder="用户名"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input prefix-icon="iconfont icon-mima" v-model="addForm.password" placeholder="密码"></el-input>
                    </el-form-item>
                    <el-form-item prop="email">
                        <el-input prefix-icon="iconfont icon-youxiang" v-model="addForm.email" placeholder="邮箱"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="addDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="addUser">确 定</el-button>
                </span>
            </el-dialog>
<!-- 用户修改区域 -->
            <el-dialog title="编辑用户" :visible.sync="editDialogVisible" width="50%" @close="editDialogClose">
                <el-form :model="editForm" :rules="editFormRules" ref="editFormRef" label-width="70px">
                    <el-form-item prop="id">
                       编号： <el-input prefix-icon="iconfont icon-bianhao" v-model="editForm.id" disabled></el-input>
                    </el-form-item>
                    <el-form-item prop="username">
                        用户名：<el-input prefix-icon="iconfont icon-iconset01100" v-model="editForm.username" placeholder="用户名"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        密码：<el-input prefix-icon="iconfont icon-mima" v-model="editForm.password" placeholder="密码"></el-input>
                    </el-form-item>
                    <el-form-item prop="email">
                        邮箱：<el-input prefix-icon="iconfont icon-youxiang" v-model="editForm.email" placeholder="邮箱"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="editDialogVisible = false">取 消</el-button>
                    <el-button type="primary" @click="editUser">确 定</el-button>
                </span>
            </el-dialog>


    </div>
</template>

<script>
    export default {
        created(){
            this.getUserList();
        },
        data(){
            return{
                pageInfo:{ //分页信息
                    info:'',
                    pageNum:1,
                    pageSize:5
                },
                userList:[], //查询出来的用户
                total:0, //总记录数

                addDialogVisible:false,
                editDialogVisible:false,
                addForm:{
                    username:'',
                    password:'',
                    email:'',
                },
                editForm:{
                    username:'',
                    password:'',
                    email:'',
                },
                addFormRules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 2, max: 6, message: '长度在 2 到 6 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请输入邮箱', trigger: 'blur' },
                        { min: 5, max: 16, message: '请输入正确邮箱', trigger: 'blur' }
                    ],
                },
                editFormRules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 2, max: 6, message: '长度在 2 到 6 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 5, max: 16, message: '长度在 5 到 16 个字符', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请输入邮箱', trigger: 'blur' },
                        { min: 5, max: 16, message: '请输入正确邮箱', trigger: 'blur' }
                    ],
                }
            }
        },
        methods:{
            // 获取用户列表
            getUserList:async function(){
               await this.$http.get('users',{params:this.pageInfo}).then(res =>{
                   this.userList = res.data.users;
                   this.total = res.data.pages;
               })
            },
            handleSizeChange(newSize){
                this.pageInfo.pageSize = newSize;
                this.getUserList();
            },
            handleCurrentChange(newNum){
                this.pageInfo.pageNum = newNum;
                this.getUserList();
            },
            async updateState(userInfo){
                await this.$http.put('updateState?id='+userInfo.id+'&state='+userInfo.state).then(res => {
                    if(res.data != 'ok'){
                        userInfo.id = !userInfo.id;
                        return this.$message.error('操作失败！')
                    }
                    this.$message.success('操作成功')
                })
            },
            dialogClose(){
                this.$refs.addFormRef.resetFields();
            },
            addUser(){
                 this.$refs.addFormRef.validate(async valid => {
                    if(!valid) return ;
                    await this.$http.post('user',this.addForm).then(res => {
                        if(res.data != 'ok'){
                            return this.$message.error('添加用户失败！');
                        }
                        this.$message.success('添加用户成功');
                        this.addDialogVisible = false;
                        this.pageInfo.info = this.addForm.username;
                        this.getUserList();
                    });
                 })
            },
             async deleteUser(id){
              const confirmResult = await this.$confirm('确定要执行此次删除用户的操作？','提示',{
                    confirmButtonText:'确定',
                    cancelButtonText:'取消',
                    type:'warning'
                }).catch(err => err)
                if(confirmResult != 'confirm'){
                    return this.$message.info('已取消此操作');
                }
                console.log(id)
                await this.$http.delete('user?id='+id).then(res => {
                    if(res.data != 'ok'){
                        this.$message.error('删除用户失败！');
                    }
                    this.$message.success('删除用户成功');
                    this.getUserList();
                })
            },
            async showEditDialog(id){
                await this.$http.get('user?id='+id).then(res => {
                    this.editForm = res.data;
                    this.editDialogVisible = true;
                })
            },
            editDialogClose(){
                this.$refs.editFormRef.resetFields();
            },
            editUser(){
                this.$refs.editFormRef.validate(async valid => {
                    if(!valid) return ;
                    await this.$http.put('user',this.editForm).then(res => {
                        if(res.data != 'ok'){
                            this.$message.error('用户信息修改失败！');
                        }
                        this.$message.success('用户信息修改成功！');
                        this.editDialogVisible = false;
                        this.getUserList();
                    })
                 })
            }

        },
    }
</script>

<style lang="less" scoped>

    .el-breadcrumb{
        margin-bottom: 15px;
        font-size: 17px;
    }

</style>