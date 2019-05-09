<template>
  <div>
    <div>物资取用登记系统</div>
    <div class="button" @click="findAllUser">查看用户</div>
    <div class="button" @click="findAllOrders">查看订单</div>
    <div class="button" @click="createOrder">创建订单</div>
    <!-- <div class="titlecustom nes-container with-title">
        <span class="title">天河游击士协会</span>
        <p>魔兽捕获登记系统</p>
    </div>
    <div class="option">2</div>-->
    <!-- <img class="bg" src="@/assets/jpg/background.jpg"> -->
    <!-- <div class="nes-container">
            <div>天河游击士协会狩魔登记系统</div>
            <div>
                <span class="nes-text is-warning">黄色</span>
                <span class="nes-text is-error">橙色</span>
                <span class="nes-text is-disabled">灰色</span>
            </div>
        </div>
        <div class="columns">
            <div class="column">
                <div class="nes-btn" @click="testBtn">白色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-primary"  @click="testBtn2">蓝色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-success">绿色</div>
            </div>
            <div class="column">
                <div class="nes-btn is-error">橙色</div>
            </div>
    </div>-->
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
.bg {
  position: absolute;
  background-repeat: repeat;
}
.body {
  display: flex;
  flex-direction: column;
  flex-wrap: nowrap;
  justify-content: center;
  align-items: center;
}

.titlecustom {
  height: 0%;
  width: 70%;
  padding-bottom: 30%;
  margin: 3%;
}
.titlecustom p {
  font-size: 70px;
  text-align: center;
}
.option {
  height: 0%;
  width: 50%;
  padding-bottom: 30%;
}
</style>