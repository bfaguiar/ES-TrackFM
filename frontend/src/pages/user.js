import React, { Component } from 'react';

class User extends Component
{
    constructor ()
    {
        super();
        this.state = 
        {
            loading : false ,
        }
    }

    componentDidMount () 
    {
    }

    render ()
    {
        return (
        <div>

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
                <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="#page-top">Track FM <b>users  </b> </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                    
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#recentracks">Recent Tracks</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#topartists">Top Artists</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#topalbums">Top Albums</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#toptracks">Top tracks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link js-scroll-trigger" href="#contact">Contact</a>
                    </li>

                    -->
                    </ul>
                </div>
                </div>
            </nav>


            <section id="userprofile">
                <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <div class="card">
                            <div class="card-body text-center">
                                <div> <img src="https://img.icons8.com/bubbles/100/000000/administrator-male.png" class="img-lg rounded-circle mb-4" alt="profile image"/>
                                    <h4>Sam Disanjo</h4>
                                    <p class="text-muted mb-0">User</p>
                                </div>
                                <br/> 
                                <div class="border-top pt-3">
                                    <div class="row">
                                        <div class="col-4">
                                            <p>Playlists</p>
                                            <h6>4354</h6>
                    
                                        </div>
                                        <div class="col-4">
                                            <p>Playcount</p>
                                            <h6>455K</h6>
                                        </div>
                                        <div class="col-4">
                                            <p>Country</p>
                                            <h6>Portugal</h6>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </section>

            <section id="recentracks" class="bg-light">
                <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                    <h2>Recent Tracks</h2>
                    <br/>
                    <br/>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Album</th>
                            <th scope="col">Artist</th>
                            <th scope="col">Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>@mdo</td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                </div>
                </div>
            </section>


            <section id="topartists">
                <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                    <h2>Top Artists</h2>
                    <br/> 
                    <br/>
                    <table class="table table-striped">

                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Playcount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                </div>
                </div>
            </section>

            <section id="topalbums" class="bg-light">
                <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                    <h2>Top Albums</h2>
                    <br/>
                    <br/>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Artist</th>
                            <th scope="col">Playcount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                </div>
                </div>
            </section>

            <section id="toptracks">
                <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                    <h2>Top Tracks</h2>
                    <br/>
                    <br/>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Playcount</th>
                            <th scope="col">Duration</th>
                            <th scope="col">Artist</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                            <td>@mdo</td>
                        </tr>
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

export default User;