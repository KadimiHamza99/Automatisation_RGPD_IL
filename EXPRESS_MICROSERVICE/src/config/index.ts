import { config } from 'dotenv';
config({ path: `.env.${process.env.NODE_ENV || 'development'}.local` });

export const CREDENTIALS = process.env.CREDENTIALS === 'true';
export const { NODE_ENV, PORT, SECRET_KEY, LOG_FORMAT, LOG_DIR, ORIGIN } = process.env;

module.exports = {
  eureka: {
    host: 'http://localhost:8760/eureka/',
    name: 'service-express',
    port: 3000,
    healthCheckUrl: '/health',
    registerWithEureka: true,
  },
};
