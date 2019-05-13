<template>
    <div>
        <!-- <div class="nes-container">
            <button type="button" class="nes-btn is-primary" @click="showdialog">弹窗测试</button>
            
        </div> -->
        <!-- <hr> -->
        <div class="nes-container with-title is-centered" style="margin:5%;">
            <span class="title" style="fontSize:3rem;color:#f7d51d;">☆ 取用物资人员 ☆</span>
            
            <div style="display:flex;justify-content:space-between;margin:1rem;">
                <div class="nes-btn is-size-1" style="width:35rem" @click="routerBack">返回</div>
                <div class="nes-btn is-size-1 is-primary" style="width:35rem" @click="routerBack">用户订单</div>
                <!-- <div class="nes-btn is-success is-size-1" style="width:10rem">新增</div> -->
                <div class="nes-btn is-error is-size-1" style="width:35rem">删除</div>
                <!-- <div class="nes-btn is-warning is-size-1" style="width:10rem">修改</div> -->
                <!-- <div class="nes-btn is-size-1" style="width:10rem">刷新</div> -->
            </div>
            <div class="customcontain">
                <div class="nes-container with-title membercard" v-for="(item,index) in allUsers" :key="index" style="margin:1rem" :class="{selectCSS:index==selectFlag}" @click="selectCssMethod(index)">
                    <span class="title" style="fontSize:2rem;color:#209cee;">{{item.userName}}</span>
                    <div><span style="color:#92cc41;fontWeight:bold;">性别：</span> {{item.userSex}}</div>
                    <div><span style="color:#92cc41;fontWeight:bold;">生日：</span> {{item.userBirthday}}</div>
                    <div><span style="color:#92cc41;fontWeight:bold;">住址：</span> {{item.userAddress}}</div>
                </div>
            </div>
            <div class="nes-container with-title" style="margin:1rem;">
                <span class="title" style="color:#e76e55;fontSize:2rem;">新增/修改用户</span>
                <div style="margin:10px;"><span style="fontSize:2rem;">姓名：</span><input type="text" class="nes-input" style="width:90%;" v-model="UpdateKey"></div>
                <div style="margin:10px;"><span style="fontSize:2rem;">性别：</span><input type="text" class="nes-input" style="width:90%;" v-model="UpdateKey"></div>
                <div style="margin:10px;"><span style="fontSize:2rem;">生日：</span><input type="text" class="nes-input" style="width:90%;" v-model="UpdateKey"></div>
                <div style="margin:10px;"><span style="fontSize:2rem;">地址：</span><input type="text" class="nes-input" style="width:90%;" v-model="UpdateKey"></div>
                <div class="nes-btn is-success is-size-1" style="width:70rem">新增/修改</div>
            </div>
        </div>
        <!-- <div style="display:flex;justify-content:space-around;marginTop:2rem;marginBottom:2rem;">
            <dialog class="nes-dialog " id="dialog-default">
            <form method="dialog">
                <p class="title">Dialog</p>
                <p>Alert:this is a dialog</p>
                <menu>
                    <button class="nes-btn">Cancel</button>
                    <button class="nes-btn is-primary">Confirm</button>
                </menu>
            </form>
        </dialog>
        </div> -->
        <!-- <div>这里展示全部用户</div>
        <div>
            <el-button>默认按钮</el-button>
            <el-button type="primary">主要按钮</el-button>
            <el-button type="success">成功按钮</el-button>
            <el-button type="info">信息按钮</el-button>
            <el-button type="warning">警告按钮</el-button>
            <el-button type="danger">危险按钮</el-button>
        </div>
        <div class="button" @click="reflash">刷新</div>
        <div class="button" @click="deleteUser">删除</div>
        <input class="input" type="text" v-model="delKey">
        <div class="button" @click="addUser">新增</div>
        <input class="input" type="text" v-model="userTemp.userName">
        <div class="button" @click="updateUser">更新</div>
        <input class="input" type="text" v-model="UpdateKey">
        <div class="button" @click="routerBack">返回</div>
        <table class="table">
            <tbody>
                <tr v-for="(item,index) in allUsers" :key="index" @click="getOrderList(item)">
                    <td v-for="(cell,index) in item" :key="index">
                        {{cell}}
                    </td>
                </tr>
            </tbody>
        </table> -->
    </div>
</template>
<script>
export default {
    data() {
        return {
            selectFlag:-1,
            allUsers:[],
            delKey:"需要删除的主键",
            UpdateKey:"需要更新的主键",
            userTemp:{
                "userName":"zeen"
            }
        }
    },
    mounted() {
        this.allUsers =  this.$storage.get("allUsers");

    },
    methods: {
        testpara(){
            // console.log(this.text);
            this.$ajax.post("/addUser",this.userTemp).then(response => {
                console.log('返回成功');
                console.log(response);
                
            });
            
        },
        routerBack(){
            this.$router.push("/")
        },
        reflash(){
            this.$ajax.get("/findAllUser").then(response => {
                this.allUsers = response.data;
                this.$storage.set("allUsers", response.data);
            });
        },
        deleteUser(){
            let urlTemp = "/deleteUserByPrimaryKey/"+this.delKey;
            this.$ajax.get(urlTemp).then(response => {
                console.log(response);
                
                console.log('删除成功');
                
            });
        },
        addUser(){
            // let urlTemp = "/deleteUserByPrimaryKey/"+this.delKey;
            this.$ajax.post("/addUser",this.userTemp).then(response => {
                console.log(response);
                
                console.log("连接成功");
                
            });
        },
        updateUser(){
            // let urlTemp = "/deleteUserByPrimaryKey/"+this.delKey;
            let param = {
                "userId":"20",
                "userName":"zeen"
            };
            this.$ajax.post("/updateUser",param).then(response => {
                console.log(response);
                
                console.log("更新成功");
                
            });
        },
        getOrderList(item){
            this.$router.push("/OrderList");
            console.log(item);
            
        },
        showdialog(){
            document.getElementById('dialog-default').showModal();
        },
        selectCssMethod(index){
            if(this.selectFlag != index){
                this.selectFlag = index;
            }else{
                this.selectFlag = -1;
            }
        }
    },
}
</script>
<style scope>
.customcontain{
    display: flex;
    /* justify-content: space-between; */
    flex-wrap: wrap
}
.customcontain .membercard{
    text-align: left;

    width: 22rem;
}
.selectCSS{
    background-color: #209cee85;
}
</style>