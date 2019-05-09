<template>
    <div>
        <div>这里展示全部用户</div>
        <!-- <div class="button" @click="testpara">临时测试按钮</div> -->
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
        </table>
    </div>
</template>
<script>
export default {
    data() {
        return {
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
            
        }
    },
}
</script>