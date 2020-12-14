    <!DOCTYPE html>
       <head>
          <title>Backbone.js History Example</title>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

    <script src="https://code.jquery.com/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.2/underscore-min.js"
            type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"
            type="text/javascript"></script>
       </head>
       <script type="text/javascript">

          var Router = Backbone.Router.extend({
             routes: {
                "add-user" : "addNewUser",
                "backButton":"AdminTeacherPageRender",
                "logout":"logoutRender"
             },

             //functions
             addNewUser: function () {
             console.log("add new User View")
             var userView=new UsersView();

             },

             AdminTeacherPageRender:function(){

             },
             logoutRender:function(){

             }

          });

          var router = new Router();
         Backbone.history.start({ pushState: true });
      </script>


