# Yoga Solo -  Android Code challenge


## The architecture

- As a typical approach I have used clean architecture, making 3 different modules, one for presentation, one for domain and another one for data.
- I thought of using MVVM but I prefered to use MVP as is something I am more confortable with and represents better what I'm used to do.
- I avoided using usecases as I thought it wasn't going to be useful for this particular challenge.
- I used coroutines to manage the threads for the network requests.
- I thought in the first place to make a network and local data source, so I could load the list in the master list and the retrieve the info from the local datasource in the detail.
- In the end I opted for just passing the `Posture` object as a Serializable because I didn't have much time.

## The libraries

- I have used some of the most common libraries in the Android scene
- For the network requests I have made use of `Retrofit`
- For the dependency injection I used `Koin` as for me it's the one I know better, and it's helpful for testing (I know I didn't have time for testing)
- For the image loading I made use of `Glide`
- And for generic purposes I added `Arrow` as is a library that I have been using a lot lately.

## Other considerations and things to do
- I have made use of a few of classes from one of my projects, like `ScopedActivity` or `BasePresenter`.
- I'm aware of many things that are still left to do
- TODO -> Add a real error handling with sealed classes for `Either` in the requests.
- TODO -> Add a linter
- TODO -> Add some tests
- TODO -> Add search
- TODO -> Add posture dragging system

Even with all of this things left I think the code kind of shows more or less how I code taking into consideration the limited amount of time that I had. Not because 
of your time restriction but due to personal issues and liabilities. I wish I had more time to improve the project but my time is very limited right now. I hope that
you like the test. It was fun!

Thanks!!
