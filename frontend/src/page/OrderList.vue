<template>
    <div>
        <div>这里显示订单列表</div>
        <table class="table">
            <tbody>
                <tr v-for="(item,index) in orderList" :key="index" @click="getOrderList(item)">
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
            orderList:[]
        }
    },
    created() {
        this.$ajax.get("/findorder/0").then(response => {
            this.orderList = response.data;
            this.$storage.set("orderList", response.data);
            // console.log(this.orderList);
            
            // this.$router.push("/User");
         });
    },
}
</script>