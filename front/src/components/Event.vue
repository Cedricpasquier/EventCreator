<template>
  <div class="event_form">
    <div class="form-group">
      <input class="form-control" :maxlength='maxCharacter' placeholder="Event Name" v-model="event.nomEvent">
    </div>

    <div class="form-group">
      <textarea class="form-control" placeholder="Event Description" v-model="event.descEvent"></textarea>
    </div>

    <div class="form-group">
      <input type="datetime-local" class="form-control" placeholder="Start Date" v-model="event.startDate">
    </div>

    <div class="form-group">
    <input type="datetime-local" class="form-control" placeholder="End Date" v-model="event.endDate">
    </div>

    <button class="btn btn-primary" @click="addEvent">Submit</button>
  </div>
  <div class="list_events">
    <a class="list_group_item"
        v-for="event in events"
        :key="event.nomEvent"
    >
      <div class="event">
        <h4 class="event_title">
          {{event.nomEvent}}
        </h4>
        <hr>
        <h4 >
          Description
        </h4>

        <p class="event_desc">
          {{event.descEvent}}
        </p>
        <hr>
        <p>
          <b>Start</b> : {{event.startDate}}
        </p>
        <p>
          <b>End</b> :  {{event.endDate}}
        </p>
        <p class="timezone">
          <b>UTC</b> : {{(-1*(event.timezone/60))}}
        </p>
      </div>
    </a>
  </div>
</template>

<script>
import axios from "axios";

const API_URL = 'http://localhost:8081/api';
export default {
  name: "EventItem",
  data() {
    return {
      event: { nomEvent: '', descEvent: '', startDate: '', endDate: '' , timezone: ''},
      events: [],
      response: String,
      maxCharacter: 32
    }
  },
  mounted() {
    axios.get(API_URL + '/getevents').then(
        response => {
          this.events = response.data;
          return response.data;
        }
    )
  },
  methods: {

    addEvent() {
      const date = new Date();
      // const headers = {
      //   'Content-Type': 'application/json'
      // };
      if((this.event.nomEvent) && (this.event.descEvent) && (this.event.startDate) && (this.event.endDate)){
        return axios.post(API_URL + '/event', {
          nomEvent: this.event.nomEvent,
          descEvent: this.event.descEvent,
          startDate: this.event.startDate,
          endDate: this.event.endDate,
          timezone: date.getTimezoneOffset()
        }).then(
            response => {
              this.event = { name: '', description: '', start_date: '', end_date: '' };
              this.response = response.data;
              this.getEvent()
              return response.data;
            }
        );
      }
    },

    getEvent(){
      return axios.get(API_URL + '/getevents').then(
          response => {
            this.events = response.data;
            return response.data;
          }
      );
    }

  }
}
</script>

<style scoped>
.field {
  margin: 0 10px;
}

.event_desc{
  background-color: #98a1a9;
}

.event {
  background-color: #98a1a9;
  border-color: black;
  padding: 1px;
  margin: 5px;
}
</style>
