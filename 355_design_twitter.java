class Twitter {

    HashMap<Integer, User> users;
        int timestamp;

        class User {

            int userId;
            Deque<Twit> twits;
            Set<Integer> followees;

            public User(int userId) {
                this.userId = userId;
                this.followees = new HashSet<>();
                this.twits = new LinkedList<>();
            }
        }

        class Twit {

            int timestamp;
            int twitId;

            public Twit(int timestamp, int twitId) {
                this.timestamp = timestamp;
                this.twitId = twitId;
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
            this.users = new HashMap<>();
            this.timestamp = 0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            Twit twit = new Twit(this.timestamp++, tweetId);
            User user = users.getOrDefault(userId, new User(userId));
            user.twits.add(twit);
            if (user.twits.size() > 10) {
                user.twits.removeFirst();
            }
            users.put(userId, user);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Twit> newsFeed = new PriorityQueue<>((a,b)-> b.timestamp - a.timestamp);
            if (users.containsKey(userId)) {
                User user = users.get(userId);
                for (Integer followeeId : user.followees) {
                    if (users.containsKey(followeeId)) {
                        newsFeed.addAll(users.get(followeeId).twits);
                    }
                }
                newsFeed.addAll(user.twits);
            }
            List<Integer> result = new LinkedList<>();
            while (newsFeed.size() > 0 && result.size() < 10) {
                result.add(newsFeed.poll().twitId);
            }
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followeeId != followerId) {
                User follower = users.getOrDefault(followerId, new User(followerId));
                follower.followees.add(followeeId);
                users.put(followerId, follower);
            }
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (users.containsKey(followerId)) {
                User follower = users.get(followerId);
                follower.followees.remove(followeeId);
                users.put(followerId, follower);
            }
        }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
