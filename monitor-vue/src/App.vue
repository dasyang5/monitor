<template>
    <div id="app">
        <router-view/>
    </div>
</template>

<script>
    export default {
        name: 'App'
    }
</script>

<style>
    html, body, #app {
        margin: 0;
        pading: 0;
        height: 100%;
        width: 100%;
    }

    * {
        box-sizing: border-box;
    }

</style>
