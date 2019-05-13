<template>
    <div>
        <div class="nes-container with-title is-centered" style="margin:5%;">
            <span class="title" style="fontSize:3rem;color:#e76e55;">☆ 全部取用记录 ☆</span>

            <div style="display:flex;justify-content:space-between;margin:1rem;">
                <div class="nes-btn is-size-1" style="width:25rem" @click="routerBack">返回</div>
                <div class="nes-btn is-size-1 is-primary" style="width:25rem" @click="creatOrder">新增</div>
                <div class="nes-btn is-size-1 is-warning" style="width:25rem">删除</div>
            </div>

            <table class="nes-table is-bordered" style="width:100%;">
                <thead>
                    <tr >
                        <th class="tableTittle">订单编号</th>
                        <th class="tableTittle">物资总数</th>
                        <th class="tableTittle">创建时间</th>
                        <th class="tableTittle">订单金额</th>
                        <th class="tableTittle">备注</th>
                        <th class="tableTittle">订单详情</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item,index) in allOrders" :key="index"  :class="{selectRow:index==selectFlag}" @click="rowSelect(index)">
                        <td>{{item.orderId}}</td>
                        <td>{{item.orderGoodscount}}</td>
                        <td>{{item.createtime}}</td>
                        <td>null</td>
                        <td>{{item.orderNote}}</td>
                        <td style="textAlign: center;">
                            <div class="nes-btn is-size-1 is-error" @click="findUserOrder(item.orderUserid)">查看详情</div>
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
            selectFlag:-1,
            allOrders:[]
        }
    },
    created() {
        this.allOrders = this.$storage.get("allOrders");
    },
    methods: {
        routerBack(){
            this.$router.push("/")
        },
        rowSelect(index){
            if (this.selectFlag != index) {
                this.selectFlag = index;
            }else{
                this.selectFalg = -1;
            }
        },
        creatOrder(){
            this.$router.push("/Items")
        },
        findUserOrder(orderUserid){
            console.log(orderUserid);
            this.$router.push("/Items")
        },
    },
}
</script>
<style scope>
.selectRow{
    background-color:#e76d557e;
}
.tableTittle{
    text-align: center;
    font-size: 2rem;
}    
</style>