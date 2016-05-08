#[macro_use]
extern crate rustless;

extern crate iron;
extern crate url;
extern crate rustc_serialize as serialize;
extern crate valico;

use std::collections::HashMap;

use std::fmt;
use std::error;
use std::error::Error as StdError;
use valico::json_dsl;

use rustless::server::status;
use rustless::errors::{Error};
use rustless::batteries::swagger;
use rustless::{Nesting};

use serialize::json::ToJson;

#[derive(Debug)]
pub struct InvalidMail;

impl error::Error for InvalidMail {
    fn description(&self) -> &str {
        return "InvalidMail";
    }
}

impl fmt::Display for InvalidMail {
    fn fmt(&self, formatter: &mut fmt::Formatter) -> fmt::Result {
        self.description().fmt(formatter)
    }
}

fn main() {

    let app = rustless::Application::new(rustless::Api::build(|api| {
        // api.prefix("api");
        // api.version("v1", rustless::Versioning::AcceptHeader("chat"));

        api.mount(swagger::create_api("api-docs"));

        api.error_formatter(|err, _media| {
            match err.downcast::<InvalidMail>() {
                Some(_) => {
                    return Some(rustless::Response::from(
                        status::StatusCode::BadRequest,
                        Box::new("Please provide correct `token` parameter")
                    ))
                },
                None => None
            }
        });

        api.get("users", |endpoint| {
            endpoint.summary("Lists all registered users");
            endpoint.desc("");
            endpoint.handle(|client, params| {
                client.json(&params.to_json())
            })
        });

        api.post("user", |endpoint| {
            endpoint.summary("Creates a user");
            endpoint.desc("Use this to create a user");
            endpoint.params(|params| {
                params.req_typed("name", json_dsl::string());
                params.req_typed("pwd", json_dsl::string());
                params.opt_typed("mail", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("{}", params.find_path(&["name"]).unwrap());
                client.json(params)
            })
        });

        api.get("user/:id", |endpoint| {
            endpoint.summary("Retrieves user data");
            endpoint.desc("Use this to retrieve a users data");
            endpoint.params(|params| {
                params.req_typed("name", json_dsl::string());
                params.req_typed("pwd", json_dsl::string());
                params.opt_typed("byname", json_dsl::boolean());
            });
            endpoint.handle(|client, params| {
                println!("Get User ID");
                client.json(params)
            })
        });

        api.put("user/:id", |endpoint| {
            endpoint.summary("Updates a user");
            endpoint.desc("Use this to update a users data");
            endpoint.params(|params| {
                params.req_typed("name", json_dsl::string());
                params.req_typed("pwd", json_dsl::string());
                params.opt_typed("name", json_dsl::string());
                params.opt_typed("mail", json_dsl::string());
                params.opt_typed("newpwd", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Update User ID");
                client.json(params)
            })
        });

        api.delete("user/:id", |endpoint| {
            endpoint.summary("Deletes a user");
            endpoint.desc("Use this to delete a user");
            endpoint.params(|params| {
                params.req_typed("id", json_dsl::string());
                params.req_typed("pwd", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Delete User ID");
                client.json(params)
            })
        });

        api.get("games", |endpoint| {
            endpoint.summary("Lists all registered games");
            endpoint.desc("Use this to list all registered games");
            endpoint.handle(|client, params| {
                println!("Update User ID");
                client.json(params)
            })
        });

        api.post("game", |endpoint| {
            endpoint.summary("Creates a game");
            endpoint.desc("Use this to create a game");
            endpoint.params(|params| {
                params.req_typed("name", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
                params.opt_typed("url", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Create game");
                client.json(params)
            })
        });

        api.get("game/:id", |endpoint| {
            endpoint.summary("Creates a game");
            endpoint.desc("Use this to create a game");
            endpoint.params(|params| {
                params.req_typed("secret", json_dsl::string());
                params.req_typed("id", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Get game");
                client.json(params)
            })
        });

        api.put("game/:id", |endpoint| {
            endpoint.summary("Updates a game");
            endpoint.desc("Use this to update a game");
            endpoint.params(|params| {
                params.req_typed("id", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
                params.opt_typed("name", json_dsl::string());
                params.opt_typed("url", json_dsl::string());
                params.opt_typed("newsecret", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Update game");
                client.json(params)
            })
        });

        api.delete("game/:id", |endpoint| {
            endpoint.summary("Delete a game");
            endpoint.desc("Use this to delete a game");
            endpoint.params(|params| {
                params.req_typed("id", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Delete game");
                client.json(params)
            })
        });

        api.get("gamestate/:gameid", |endpoint| {
            endpoint.summary("Retrieves all gamestates for a game");
            endpoint.desc("..");
            endpoint.params(|params| {
                params.req_typed("gameid", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Get gamestates");
                client.json(params)
            })
        });

        api.get("gamestate/:gameid/:userid", |endpoint| {
            endpoint.summary("Retrieves gamestates for a game and user");
            endpoint.desc("..");
            endpoint.params(|params| {
                params.req_typed("gameid", json_dsl::string());
                params.req_typed("userid", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
            });
            endpoint.handle(|client, params| {
                println!("Get game and user");
                client.json(params)
            })
        });

        api.post("gamestate/:gameid/:userid", |endpoint| {
            endpoint.summary("Updates gamestates for a game and user");
            endpoint.desc("..");
            endpoint.params(|params| {
                params.req_typed("gameid", json_dsl::string());
                params.req_typed("userid", json_dsl::string());
                params.req_typed("secret", json_dsl::string());
                params.req_typed("state", json_dsl::string());
                //TODO check state thingy
            });
            endpoint.handle(|client, params| {
                println!("Get game and user");
                client.json(params)
            })
        });

    }));

    let mut chain = iron::Chain::new(app);

    iron::Iron::new(chain).http("0.0.0.0:4000").unwrap();
    println!("On 4000");

}
