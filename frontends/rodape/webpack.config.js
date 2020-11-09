const webpackMerge = require("webpack-merge");
const singleSpaDefaults = require("webpack-config-single-spa-react");

module.exports = (webpackConfigEnv, argv) => {
  const defaultConfig = singleSpaDefaults({
    orgName: "multiplica",
    projectName: "rodape",
    webpackConfigEnv,
    argv,
    devServer: {
      disableHostCheck: true,
    },
  });

  return webpackMerge.smart(defaultConfig, {
    // modify the webpack config however you'd like to by adding to this object
  });
};
