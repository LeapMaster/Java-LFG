# Shea Prewett Individual Project

### Project Statement

Many games offer challenging cooperative activities, ones that mandate a great deal of cooperation and preparation in exchange for higher rewards. Forming groups able and willing to take on these challenges is a challenge that many games struggle with; most of these have some way to quickly form groups, but looking for certain types of groups under certain desirable parameters can be a mess in the jumble of highly active in-game chat channels.

One of the more popular community-made solutions is to build an "LFG", or "Looking for Group" site that allows players to make detailed postings. These postings are generally sorted by recent first, and are able to be sorted by a number of parameters such as activity and platform. I would like to build a basic site that could be easily modified to fit for almost any game. As such, there are a number of features I would consider essential, as well as a few extra "stretch goals" that would be fun to implement if I have the time and capability.

### Essential

* Live, constantly-updating feed of detailed posts. These posts need to show all relevant data, as well as how long ago it was posted, generated with each refresh. I need to, at the very least, have a refresh button that refreshes the feed without reloading the page; using javascript for active updating would be ideal. Having both as options would be great.

* Lots of easily-configurable fields for sufficiently detailed posts.

* Self-maintaining database. All posts need to have a limited life span to prevent storage from becoming flooded with quickly-useless data. I would ideally do this either using maximum storage values for categories, or simply having timed clearing of posts older than a certain amount. This is not a forum, this is mean to facilitate fast connections. 

* Dynamic HTML; detailed forms need to be hidden to make room to view the feed.

* Some kind of captcha-like validation to prevent spam/advertising from overrunning the site.

* Optional account registration; cookies should be used when possible to retain data between sessions, but being able to log in could afford some streamlining of the input process.

### Fun Stuff

* Instant, peer-to-peer, no-registration chat. Click on a User's post and talk to them! I was blown away when I saw this done on one site, and while most likely pretty challenging, it would be very cool to get this working.

* Integration with game API. Being able to make character data a part of the posts would be pretty slick.

* A live counter of users active on the site. Once again, no idea how to do this, but it'd be pretty nice to give players an immediate idea of site activity.

* Integration with advertisement or donation buttons. While I'd like to keep these minimal, it would be pretty cool to see how to go about monetization of our web sites.

* Pretty minor, but some degree of social media involvement (such as a button to like on Facebook) would be interesting.

