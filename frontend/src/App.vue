<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <div class="navbar-brand">To Watch List</div>
        <div class="collapse navbar-collapse">
          <div class="navbar-nav">
            <router-link to="/all" class="nav-link">All films</router-link>
            <router-link to="/add" class="nav-link">Add new film</router-link>
            <router-link to="/find" class="nav-link">Find  films</router-link>
          </div>
        </div>
      </div>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>
