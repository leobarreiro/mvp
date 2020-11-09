import React from "react";

export default function Root(props) {
  return (
    <section>
      <div class="page-header">
        <h1>Eu sou o mfe {props.name}</h1>
      </div>
      <div class="alert alert-success" role="alert">
        <strong>Well done!</strong> You successfully read this important alert
        message.
      </div>
      <p>
        <button type="button" class="btn btn-lg btn-default">
          Default
        </button>
        <button type="button" class="btn btn-lg btn-primary">
          Primary
        </button>
        <button type="button" class="btn btn-lg btn-success">
          Success
        </button>
        <button type="button" class="btn btn-lg btn-info">
          Info
        </button>
        <button type="button" class="btn btn-lg btn-warning">
          Warning
        </button>
        <button type="button" class="btn btn-lg btn-danger">
          Danger
        </button>
        <button type="button" class="btn btn-lg btn-link">
          Link
        </button>
      </p>
    </section>
  );
}
