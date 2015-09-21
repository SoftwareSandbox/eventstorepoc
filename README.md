# eventstorepoc
POC of EventStore

# Setting up EventStore with docker
We used [Andrew Browne's docker file](https://hub.docker.com/r/adbrowne/eventstore/)
`docker pull adbrowne/eventstore`
`docker run -d -p 2113:2113 -p 1113:1113 adbrowne/eventstore`
After this, you should be able to browse to the eventstore web admin at http://localhost:2113.

If you can't see any of your own streams at first, that's normal. Streams get dynamically added. Just run the `AtomPoster` and you should see a `fiangular` stream added in the `Stream browser`.