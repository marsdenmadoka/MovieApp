// Generated by Dagger (https://dagger.dev).
package com.madoka.movieshop.screens.home;

import com.madoka.domain.usecase.NowPlayingMovieListUseCase;
import com.madoka.domain.usecase.PopularMoviesUseCase;
import com.madoka.domain.usecase.TrendingMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<NowPlayingMovieListUseCase> playingNowUseCaseProvider;

  private final Provider<TrendingMoviesUseCase> trendingMovieUseCaseProvider;

  private final Provider<PopularMoviesUseCase> popularMovieUsesCaseProvider;

  public HomeViewModel_Factory(Provider<NowPlayingMovieListUseCase> playingNowUseCaseProvider,
      Provider<TrendingMoviesUseCase> trendingMovieUseCaseProvider,
      Provider<PopularMoviesUseCase> popularMovieUsesCaseProvider) {
    this.playingNowUseCaseProvider = playingNowUseCaseProvider;
    this.trendingMovieUseCaseProvider = trendingMovieUseCaseProvider;
    this.popularMovieUsesCaseProvider = popularMovieUsesCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(playingNowUseCaseProvider.get(), trendingMovieUseCaseProvider.get(), popularMovieUsesCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<NowPlayingMovieListUseCase> playingNowUseCaseProvider,
      Provider<TrendingMoviesUseCase> trendingMovieUseCaseProvider,
      Provider<PopularMoviesUseCase> popularMovieUsesCaseProvider) {
    return new HomeViewModel_Factory(playingNowUseCaseProvider, trendingMovieUseCaseProvider, popularMovieUsesCaseProvider);
  }

  public static HomeViewModel newInstance(NowPlayingMovieListUseCase playingNowUseCase,
      TrendingMoviesUseCase TrendingMovieUseCase, PopularMoviesUseCase PopularMovieUsesCase) {
    return new HomeViewModel(playingNowUseCase, TrendingMovieUseCase, PopularMovieUsesCase);
  }
}
