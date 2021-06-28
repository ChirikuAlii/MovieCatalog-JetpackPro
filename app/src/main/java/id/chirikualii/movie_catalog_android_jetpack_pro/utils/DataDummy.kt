package id.chirikualii.movie_catalog_android_jetpack_pro.utils

import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.MovieEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.local.entity.TvShowEntity
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverMovieResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.data.remote.response.DiscoverTvShowsResponse
import id.chirikualii.movie_catalog_android_jetpack_pro.model.Movie
import id.chirikualii.movie_catalog_android_jetpack_pro.model.TvShow

/**
 * Create by Chiriku Alii on 6/10/21
 * github.com/chirikualii
 */
object DataDummy {


    fun getMovieList(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                movieId = 337404,
                title = "Cruella",
                desc = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                poster = "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                backdrop = "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                releaseDate = "2021-05-26"
            ),


            MovieEntity(
                movieId = 637649,
                title = "Wrath of Man",
                desc = "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                poster = "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                backdrop = "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                releaseDate = "2021-04-22"
            ),
            MovieEntity(
                movieId = 632357,
                title = "The Unholy",
                desc = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                poster = "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                backdrop = "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
                releaseDate = "2021-03-31"
            ),
            MovieEntity(
                movieId = 602734,
                title = "Spiral: From the Book of Saw",
                desc = "Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.",
                poster = "/lcyKve7nXRFgRyms9M1bndNkKOx.jpg",
                backdrop = "/7JENyUT8ABxcvrcijDBVpdjgCY9.jpg",
                releaseDate = "2021-05-12"
            ),
            MovieEntity(
                movieId = 503736,
                title = "Army of the Dead",
                desc = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                poster = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                backdrop = "/9WlJFhOSCPnaaSmsrv0B4zA8iUb.jpg",
                releaseDate = "2021-05-14"
            ),
            MovieEntity(
                movieId = 423108,
                title = "The Conjuring: The Devil Made Me Do It",
                desc = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                poster = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                backdrop = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                releaseDate = "2021-05-25"
            ),
            MovieEntity(
                movieId = 399566,
                title = "Godzilla vs. Kong",
                desc = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                poster = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                backdrop = "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                releaseDate = "2021-03-24"
            ),
            MovieEntity(
                movieId = 460465,
                title = "Mortal Kombat",
                desc = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                poster = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                backdrop = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                releaseDate = "2021-04-07"
            ),
            MovieEntity(
                movieId = 567189,
                title = "Tom Clancy's Without Remorse",
                desc = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                poster = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                backdrop = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                releaseDate = "2021-04-29"
            ),
            MovieEntity(
                movieId = 578701,
                title = "Those Who Wish Me Dead",
                desc = "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                poster = "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                backdrop = "/ouOojiypBE6CD1aqcHPVq7cJf2R.jpg",
                releaseDate = "2021-05-05"
            ),
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                tvShowId = 63174,
                title = "Lucifer",
                desc = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                poster = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                backdrop = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                releaseDate = "2016-01-25"
            ),
            TvShowEntity(
                tvShowId = 91557,
                title = "Ragnarok",
                desc = "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                poster = "/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                backdrop = "/wu444tM9YBllq9UcBv5TeidO3j3.jpg",
                releaseDate = "2020-01-31"
            ),
            TvShowEntity(
                tvShowId = 60735,
                title = "The Flash",
                desc = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                poster = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                backdrop = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                releaseDate = "2014-10-07"
            ),
            TvShowEntity(
                tvShowId = 71712,
                title = "The Good Doctor",
                desc = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                poster = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                backdrop = "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                releaseDate = "2017-09-25"
            ),
            TvShowEntity(
                tvShowId = 84958,
                title = "Loki",
                desc = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                poster = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                backdrop = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                releaseDate = "2021-06-09"
            ),
            TvShowEntity(
                tvShowId = 1416,
                title = "Grey's Anatomy",
                desc = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                poster = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                backdrop = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                releaseDate = "2005-03-27"
            ),
            TvShowEntity(
                tvShowId = 88396,
                title = "The Falcon and the Winter Soldier",
                desc = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                poster = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                backdrop = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                releaseDate = "2021-03-19"
            ),
            TvShowEntity(
                tvShowId = 95057,
                title = "Superman & Lois",
                desc = "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                poster = "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                backdrop = "/pPKiIJEEcV0E1hpVcWRXyp73ZpX.jpg",
                releaseDate = "2021-02-23"
            ),
            TvShowEntity(
                tvShowId = 115004,
                title = "Mare of Easttown",
                desc = "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.",
                poster = "/78aK4Msbr22A5PGa6PZV0pAvdwf.jpg",
                backdrop = "/7X1IGIl1JMJ9YFzJymCVoqZbvTR.jpg",
                releaseDate = "2021-04-18"
            ),
            TvShowEntity(
                tvShowId = 120168,
                title = "Who Killed Sara?",
                desc = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                poster = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                backdrop = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                releaseDate = "2021-03-24"
            )
        )
    }

    fun getMovieResponseList(): List<DiscoverMovieResponse.MovieResponse> {
        return listOf(
            DiscoverMovieResponse.MovieResponse(
                id = 337404,
                title = "Cruella",
                overview = "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                posterPath = "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                backdropPath = "/6MKr3KgOLmzOP6MSuZERO41Lpkt.jpg",
                voteAverage = 8.7,
                releaseDate = "2021-05-26"
            ),


            DiscoverMovieResponse.MovieResponse(
                id = 637649,
                title = "Wrath of Man",
                overview = "A cold and mysterious new security guard for a Los Angeles cash truck company surprises his co-workers when he unleashes precision skills during a heist. The crew is left wondering who he is and where he came from. Soon, the marksman's ultimate motive becomes clear as he takes dramatic and irrevocable steps to settle a score.",
                posterPath = "/M7SUK85sKjaStg4TKhlAVyGlz3.jpg",
                backdropPath = "/70AV2Xx5FQYj20labp0EGdbjI6E.jpg",
                voteAverage = 7.9,
                releaseDate = "2021-04-22"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 632357,
                title = "The Unholy",
                overview = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                posterPath = "/bShgiEQoPnWdw4LBrYT5u18JF34.jpg",
                backdropPath = "/jw6ASGRT2gi8EjCImpGtbiJ9NQ9.jpg",
                voteAverage = 7.1,
                releaseDate = "2021-03-31"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 602734,
                title = "Spiral: From the Book of Saw",
                overview = "Working in the shadow of an esteemed police veteran, brash Detective Ezekiel “Zeke” Banks and his rookie partner take charge of a grisly investigation into murders that are eerily reminiscent of the city’s gruesome past.  Unwittingly entrapped in a deepening mystery, Zeke finds himself at the center of the killer’s morbid game.",
                posterPath = "/lcyKve7nXRFgRyms9M1bndNkKOx.jpg",
                backdropPath = "/7JENyUT8ABxcvrcijDBVpdjgCY9.jpg",
                voteAverage = 6.6,
                releaseDate = "2021-05-12"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 503736,
                title = "Army of the Dead",
                overview = "Following a zombie outbreak in Las Vegas, a group of mercenaries take the ultimate gamble: venturing into the quarantine zone to pull off the greatest heist ever attempted.",
                posterPath = "/z8CExJekGrEThbpMXAmCFvvgoJR.jpg",
                backdropPath = "/9WlJFhOSCPnaaSmsrv0B4zA8iUb.jpg",
                voteAverage = 6.6,
                releaseDate = "2021-05-14"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 423108,
                title = "The Conjuring: The Devil Made Me Do It",
                overview = "Paranormal investigators Ed and Lorraine Warren encounter what would become one of the most sensational cases from their files. The fight for the soul of a young boy takes them beyond anything they'd ever seen before, to mark the first time in U.S. history that a murder suspect would claim demonic possession as a defense.",
                posterPath = "/xbSuFiJbbBWCkyCCKIMfuDCA4yV.jpg",
                backdropPath = "/qi6Edc1OPcyENecGtz8TF0DUr9e.jpg",
                voteAverage = 8.4,
                releaseDate = "2021-05-25"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 399566,
                title = "Godzilla vs. Kong",
                overview = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                posterPath = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                backdropPath = "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                voteAverage = 8.1,
                releaseDate = "2021-03-24"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 460465,
                title = "Mortal Kombat",
                overview = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                posterPath = "/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                backdropPath = "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
                voteAverage = 7.5,
                releaseDate = "2021-04-07"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 567189,
                title = "Tom Clancy's Without Remorse",
                overview = "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                posterPath = "/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                backdropPath = "/fPGeS6jgdLovQAKunNHX8l0avCy.jpg",
                voteAverage = 7.2,
                releaseDate = "2021-04-29"
            ),
            DiscoverMovieResponse.MovieResponse(
                id = 578701,
                title = "Those Who Wish Me Dead",
                overview = "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                posterPath = "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                backdropPath = "/ouOojiypBE6CD1aqcHPVq7cJf2R.jpg",
                voteAverage = 7.0,
                releaseDate = "2021-05-05"
            ),
        )
    }

    fun getTvShowResponseList(): List<DiscoverTvShowsResponse.TvShowsResponse> {
        return listOf(
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 63174,
                name = "Lucifer",
                overview = "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                posterPath = "/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                backdropPath = "/h48Dpb7ljv8WQvVdyFWVLz64h4G.jpg",
                voteAverage = 8.5,
                firstAirDate = "2016-01-25"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 91557,
                name = "Ragnarok",
                overview = "A small Norwegian town experiencing warm winters and violent downpours seems to be headed for another Ragnarök -- unless someone intervenes in time.",
                posterPath = "/xUtOM1QO4r8w8yeE00QvBdq58N5.jpg",
                backdropPath = "/wu444tM9YBllq9UcBv5TeidO3j3.jpg",
                voteAverage = 8.0,
                firstAirDate = "2020-01-31"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 60735,
                name = "The Flash",
                overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                posterPath = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                backdropPath = "/9Jmd1OumCjaXDkpllbSGi2EpJvl.jpg",
                voteAverage = 7.7,
                firstAirDate = "2014-10-07"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 71712,
                name = "The Good Doctor",
                overview = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                posterPath = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                backdropPath = "/iDbIEpCM9nhoayUDTwqFL1iVwzb.jpg",
                voteAverage = 8.6,
                firstAirDate = "2017-09-25"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 84958,
                name = "Loki",
                overview = "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                posterPath = "/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg",
                backdropPath = "/Afp8OhiO0Ajb3NPoCBvfu2pqaeO.jpg",
                voteAverage = 8.7,
                firstAirDate = "2021-06-09"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 1416,
                name = "Grey's Anatomy",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                posterPath = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                backdropPath = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                voteAverage = 8.2,
                firstAirDate = "2005-03-27"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 88396,
                name = "The Falcon and the Winter Soldier",
                overview = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                posterPath = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                backdropPath = "/b0WmHGc8LHTdGCVzxRb3IBMur57.jpg",
                voteAverage = 7.9,
                firstAirDate = "2021-03-19"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 95057,
                name = "Superman & Lois",
                overview = "After years of facing megalomaniacal supervillains, monsters wreaking havoc on Metropolis, and alien invaders intent on wiping out the human race, The Man of Steel aka Clark Kent and Lois Lane come face to face with one of their greatest challenges ever: dealing with all the stress, pressures and complexities that come with being working parents in today's society.",
                posterPath = "/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
                backdropPath = "/pPKiIJEEcV0E1hpVcWRXyp73ZpX.jpg",
                voteAverage = 8.3,
                firstAirDate = "2021-02-23"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 115004,
                name = "Mare of Easttown",
                overview = "A detective in a small Pennsylvania town investigates a local murder while trying to keep her life from falling apart.",
                posterPath = "/78aK4Msbr22A5PGa6PZV0pAvdwf.jpg",
                backdropPath = "/7X1IGIl1JMJ9YFzJymCVoqZbvTR.jpg",
                voteAverage = 8.1,
                firstAirDate = "2021-04-18"
            ),
            DiscoverTvShowsResponse.TvShowsResponse(
                id = 120168,
                name = "Who Killed Sara?",
                overview = "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                posterPath = "/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                backdropPath = "/dYvIUzdh6TUv4IFRq8UBkX7bNNu.jpg",
                voteAverage = 7.8,
                firstAirDate = "2021-03-24"
            )
        )
    }
}