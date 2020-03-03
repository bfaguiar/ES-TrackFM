import React, { Component } from 'react';

class Index extends Component
{
    constructor ()
    {
        super();
        this.state = 
        {
            loading : true ,
            artists : [],
        }
    }

    componentDidMount () 
    {
        this.setState({ isLoading: true });
        fetch(' http://localhost:8080/artists/')
            .then(response => response.json())
            .then(data => this.setState(
                {
                    artists: data,
                    isLoading: false
                }   
            ));  
        //https://www.robinwieruch.de/react-fetching-data
    }

    render ()
    {
        const { artists , isLoading} = this.state;

        return(
            <div>
                                
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
                    <div class="container">
                    <a class="navbar-brand js-scroll-trigger" href="#page-top">Track FM</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link js-scroll-trigger" href="#artistscharts">Artist Chart</a>
                        </li>
                        </ul>
                    </div>
                    </div>
                </nav>

                <header class="bg-primary text-white">
                    <div class="container text-center">
                    <h1>Track a person</h1>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">@</span>
                        </div>
                        <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1"/>
                    </div>
                    </div>
                </header>

                <section id="artistscharts">
                    <div class="container">
                    <div class="row">
                        <div class="col-lg-8 mx-auto">
                        <h2 align="center">Global Top 50 Artist Chart</h2>
                        <br/>
                        <br/>
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Name</th>
                                <th scope="col">Playcount</th>
                                <th scope="col">Listeners</th>
                            </tr>
                            </thead>
                            <tbody>

                                { !isLoading ? ( artists.map( (artist, index) => {
                                        return(
                                            <tr>
                                                <th scope="row">{index+1}</th>
                                                <td>{artist.name}</td>
                                                <td>{parseInt(artist.playcount).toLocaleString(navigator.language, {minimumFractionDigits: 0})}</td>
                                                <td>{parseInt(artist.listeners).toLocaleString(navigator.language, {minimumFractionDigits: 0})}</td>
                                            </tr>
                                        );
                                    })
                                ) : ( <h3> Loading ... </h3> ) }

                            </tbody>
                        </table>
                        </div>
                    </div>
                    </div>
                </section>

                <footer class="py-5 bg-dark">
                    <div class="container">
                    <p class="m-0 text-center text-white">Copyright &copy; es.labproj.trackfm</p>
                    </div>
                </footer>
            </div>
      )
    }

}

export default Index;


