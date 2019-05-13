<template>
  <div>
    <div class="nes-container is-centered containcustom" style="margin:5%;">
      <i class="nes-kirby"></i>
      <div class="title" style="fontSize:7rem;color:rgb(57,114,206)" >物资取用登记系统</div>
      <el-row type="flex" justify="center">
        <el-col :span="6"><div class="nes-btn is-size-1 is-warning" @click="findAllUser">全部用户</div></el-col>
        <el-col :span="6"><div class="nes-btn is-size-1 is-success">新取用</div></el-col>
        <el-col :span="6"><div class="nes-btn is-size-1 is-error">历史记录</div></el-col>
      </el-row>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {
    findAllUser() {
      this.$ajax.get("/findAllUser").then(response => {
        this.$storage.set("allUsers", response.data);
        this.$router.push("/User");
      });
    },
    findAllOrders() {
        this.$router.push("/OrderList");
    },
    createOrder(){
        this.$router.push("/Items");
    },
  }
};
</script>
<style scope>
el-col div{
  margin: 1rem;
}
</style>