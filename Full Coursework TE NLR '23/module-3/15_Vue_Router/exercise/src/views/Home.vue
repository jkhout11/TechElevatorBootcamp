<template>
  <div>
    <best-seller-list />
    <new-releases-list />
  </div>
</template>

<script>
import NewReleasesList from '../components/NewReleasesList.vue';
import BestSellerList from '../components/BestSellerList.vue';
  export default { 
    components: {
        BestSellerList,
        NewReleasesList
    },
    computed: {}
  }
</script>
<style scoped>
</style>