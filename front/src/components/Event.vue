<template>
  <div class="event">
    <div class="form-group">
      <input class="form-control" placeholder="Event Name" v-model="event.name">
    </div>

    <div class="form-group">
      <textarea class="form-control" placeholder="Event Description" v-model="event.description"></textarea>
    </div>

    <div class="form-group">
      <input type="date" class="form-control" placeholder="Start Date" v-model="event.start_date">
    </div>

    <div class="form-group">
    <input type="date" class="form-control" placeholder="End Date" v-model="event.end_date">
    </div>

    <button class="btn btn-primary" @click="addEvent">Submit</button>
  </div>
  <div class="list_events">
    <ul id="example-1">
      <li class="list_group_item"
          v-for="event in events"
          :key="event.name"
      >
        <h4 class="event_title">
          {{event.name}}
        </h4>
        <h5 class="event_date">
          {{event.start_date}}
        </h5>
        <h5>
          {{event.end_date}}
        </h5>
        <p class="desciption_event">
          {{event.description}}
        </p>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "EventItem",
  data() {
    return {
      event: { name: '', description: '', start_date: '', end_date: '' , gmt: ''},
      events: []
    }
  },
  methods: {
    addEvent: function() {
      if(this.event.name) {
        this.events.push(this.event);
        this.event = { name: '', description: '', start_date: '', end_date: '' }
      }
    }
  }
}
</script>

<style scoped>
.field {
  margin: 0 10px;
}
</style>
