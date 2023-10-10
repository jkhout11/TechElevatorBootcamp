<template>
  <div>
      <table>
        <thead>
          <th>Title</th>
          <th>Reviewer</th>
          <th>Review</th>
          <th>Rating</th>
          <th>Favorited</th>
        </thead>
      </table>
      <tbody>
        <review-table-row
        v-for="review in $store.state.reviews"
        v-bind:key="review.id"
        v-bind:review="{ review:  }"
        />

         <!-- Only show when there are no reviews -->
        <tr>
            <td colspan="5"> There are no reviews</td>
        </tr>
      </tbody>
  </div>
</template>

<script>
import ReviewTableRow from "./review"

export default {
  name: "review-table"



};
</script>

<style scoped>
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
.stars {
  display: flex;
}
</style>
