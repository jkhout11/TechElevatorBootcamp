<template>
  <table id="tblUsers">
    <thead>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Email Address</th>
        <th>Status</th>
      </tr>
    </thead>
    <tbody>
      <!-- #4-1 filter inputs -->
      <tr>
        <td><input type="text" id="firstNameFilter" v-model="search.firstName" /></td>
        <td><input type="text" id="lastNameFilter" v-model="search.lastName" /></td>
        <td><input type="text" id="usernameFilter" v-model="search.username" /></td>
        <td><input type="text" id="emailFilter" v-model="search.emailAddress" /></td>
        <td>
          <select id="statusFilter" v-model="search.status">
            <option value="">Show All</option>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
          </select>
        </td>
      </tr>
      <!-- #3 display users using v-for -->
      <!-- # 6 inactive list -->
      <tr v-for="user in filteredList" :key="user.username" :class="{ inactive: user.status === 'Inactive' }"> 
        <td>{{ user.firstName }}</td>
        <td>{{ user.lastName }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.emailAddress }}</td>
        <td>{{ user.status }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
  name: 'user-list',
  data() {
    return {
      users: [
        { firstName: 'John', lastName: 'Smith', username: 'jsmith', emailAddress: 'jsmith@gmail.com', status: 'Active' },
        { firstName: 'Anna', lastName: 'Bell', username: 'abell', emailAddress: 'abell@yahoo.com', status: 'Active' },
        { firstName: 'George', lastName: 'Best', username: 'gbest', emailAddress: 'gbest@gmail.com', status: 'Inactive' },
        { firstName: 'Ben', lastName: 'Carter', username: 'bcarter', emailAddress: 'bcarter@gmail.com', status: 'Active' },
        { firstName: 'Katie', lastName: 'Jackson', username: 'kjackson', emailAddress: 'kjackson@yahoo.com', status: 'Active' },
        { firstName: 'Mark', lastName: 'Smith', username: 'msmith', emailAddress: 'msmith@foo.com', status: 'Inactive' }
      ],
      // #4-2 Search object with properties for filtering
      search: {
        firstName: '',
        lastName: '',
        username: '',
        emailAddress: '',
        status: ''
      }
    };
  },
  // #5 computed property for filtered list
  computed: {
    filteredList() {
      const { firstName, lastName, username, emailAddress, status } = this.search;
      return this.users.filter((user) => {
        return (
          user.firstName.toLowerCase().includes(firstName.toLowerCase()) &&
          user.lastName.toLowerCase().includes(lastName.toLowerCase()) &&
          user.username.toLowerCase().includes(username.toLowerCase()) &&
          user.emailAddress.toLowerCase().includes(emailAddress.toLowerCase()) &&
          (status === '' || user.status === status)
        );
      });
    }
  }
};
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}
th {
  text-transform: uppercase;
}
td {
  padding: 10px;
}
tr.inactive {
  color: red;
}
input,
select {
  font-size: 16px;
}
</style>
