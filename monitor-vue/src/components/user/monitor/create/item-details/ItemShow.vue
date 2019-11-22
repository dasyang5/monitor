<template>
    <div class="item-display-block">
        <component :style="option.mainOption.style" :is="items[itemType]" ref="item" :option="option"></component>
    </div>
</template>

<script>
    import Bar001 from "./echarts/Bar001";
    import Bar002 from "./echarts/Bar002";
    import Pie001 from "./echarts/Pie001";
    import Line001 from "./echarts/Line001";
    import Title001 from "./title/Title001";

    export default {
        name: "ItemShow",
        data() {
            return {
                items: {
                    'bar-1': Bar001,
                    'bar-2': Bar002,
                    'pie-1': Pie001,
                    'line-1': Line001,
                    'title-1': Title001
                }
            }
        },
        props: {
            option: {},
            h: Number,
            w: Number
        },
        methods: {
            resizeItem() {
                if (this.$refs.item != null) {
                    this.$refs.item.resize();
                }
            }
        },
        computed: {
            itemType() {
                try {
                    return this.option.mainOption.type[this.option.mainOption.type.length - 1];
                } catch (e) {
                    return null;
                }
            }
        }
    }
</script>

<style scoped>
    .item-display-block {
        height: 100%;
        width: 100%;
    }
</style>
