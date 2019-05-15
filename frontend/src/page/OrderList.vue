<template>
  <div>
    <div class="bg"></div>
    <div class="nes-container with-title is-centered" style="margin:5%;backgroundColor:#fff;">
      <span class="title" style="fontSize:3rem;color:#e76e55;">☆ 全部取用记录 ☆</span>
      <div style="display:flex;justify-content:space-between;margin:1rem;">
        <div class="nes-btn is-size-1" style="width:25rem" @click="routerBack">返回</div>
        <div class="nes-btn is-size-1 is-primary" style="width:25rem" @click="creatOrder">新增</div>
        <div class="nes-btn is-size-1 is-warning" style="width:25rem" @click="deleteOrder">删除</div>
      </div>
      <div class="is-size-1" style="marginBottom:1rem;" :style="{display:userFlag}">
        <hr>用户
        <span style="color:#209cee;">&nbsp;{{userOrder}}&nbsp;</span>的全部订单
        <hr>
      </div>
      <table class="nes-table is-bordered" style="width:100%;">
        <thead>
          <tr>
            <th class="tableTittle">订单编号</th>
            <th class="tableTittle">物资总数</th>
            <th class="tableTittle">创建/更新时间</th>
            <th class="tableTittle">订单金额</th>
            <th class="tableTittle">订单详情</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="(item,index) in allOrders"
            :key="index"
            :class="{selectRow:index==selectFlag}"
            @click="rowSelect(index)"
          >
            <td>{{item.orderId}}</td>
            <td>{{item.orderGoodscount}}</td>
            <td style="textAlign: left;">{{item.createtime}}</td>
            <td
              style="textAlign: right; font-weight:bold;color:#f7d51d;"
            >￥{{item.orderNote||0}}&nbsp;</td>
            <td>
              <div class="nes-btn is-size-1 is-error" @click="findUserOrder(item)">查看详情</div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      selectFlag: -1,
      allOrders: this.$storage.get("allOrders"),
      userOrder: this.$route.params.userOrder,
      userFlag: this.$route.params.userFlag || "none"
    };
  },
  methods: {
    routerBack() {
      this.$ajax.get("/findorder/0").then(response => {
        this.$storage.set("allOrders", response.data);
      });
      this.$router.back(-1);
    },
    sleep(d) {
      for (var t = Date.now(); Date.now() - t <= d; );
    },
    rowSelect(index) {
      if (this.selectFlag != index) {
        this.selectFlag = index;
      } else {
        this.selectFlag = -1;
      }
    },
    creatOrder() {
      let userIdTemp = -1;
      if (this.$route.params.userId > 0) {
        userIdTemp = this.$route.params.userId;
      }
      this.$router.push({
        name: "Items",
        params: { userName: userIdTemp, orderId: -1 }
      });
    },
    findUserOrder(item) {
      let url = "/findorderdetail/" + item.orderId;
      this.$ajax.post(url).then(response => {
        this.$router.push({
          name: "Items",
          params: {
            detailList: response.data,
            userName: item.orderUserid,
            orderId: item.orderId
          }
        });
      });
    },
    deleteOrder() {
      let orderIdTemp = this.allOrders[this.selectFlag].orderId;
      let url = "/deleteorder/" + orderIdTemp;
      let urlDetail = "/delorderdetail/" + orderIdTemp;
      this.$ajax.post(url).then(res => {
        console.log(res.data);
        this.$ajax.post(urlDetail).then(res => {
          console.log(res.data);
          this.reflash();
        });
      });
    },
    reflash() {
      let url = "/findorder/";
      if (this.$route.params.userId > 0) {
        url += this.$route.params.userId;
      } else {
        url += 0;
      }
      this.$ajax.get(url).then(response => {
        this.allOrders = response.data;
        this.$storage.set("allOrders", response.data);
        this.selectFlag = -1;
      });
    }
  }
};
</script>
<style scope>
.selectRow {
  background-color: #e76d557e;
}
.tableTittle {
  text-align: center;
  font-size: 2rem;
}
.bg {
  background-image: url("../assets/jpg/background2.jpg");
  background-size: 100% 100%;
  height: 100%;
  position: fixed;
  width: 100%;
  top: 0;
}
tbody tr td {
  text-align: center;
  font-size: 2rem;
  vertical-align: middle;
}
</style>